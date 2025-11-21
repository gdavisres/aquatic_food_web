package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Orca extends AnimalSubject {
    public enum ORCA_STATE { HUNTING, SOCIALIZING, MIGRATING, ROAMING }
    private ORCA_STATE currentState;
    private int packSize;
    private boolean matingSeason;
    private int migrationCounter = 0;

    public void hunt() {
        currentState = ORCA_STATE.HUNTING;
        System.out.println(getName() + " is HUNTING in a pack of " + packSize + "! Energy: " + energy);
        energy -= 15;
        
        // Chance to eat
        if(Math.random() > 0.4) {
             System.out.println(">>> " + getName() + " and pack CAUGHT PREY! Energy restored. <<<");
             energy += 40;
             if(energy > 100) energy = 100;
        }

        notifyObservers();
    }
    public void socialize() {
        currentState = ORCA_STATE.SOCIALIZING;
        System.out.println(getName() + " is SOCIALIZING. Energy: " + energy);
        energy -= 2; // Socializing burns energy
    }
    public void migrate() {
        currentState = ORCA_STATE.MIGRATING;
        System.out.println(getName() + " is MIGRATING. Energy: " + energy);
        energy -= 5;
    }
    public void roam() {
        currentState = ORCA_STATE.ROAMING;
        System.out.println(getName() + " is ROAMING. Energy: " + energy);
        energy -= 5;
    }
    public void setState(ORCA_STATE newState) {
        this.currentState = newState;
    }
    @Override
    public SUBJECT_STATE getState() {
        if (currentState == ORCA_STATE.HUNTING) return SUBJECT_STATE.HUNTING;
        return SUBJECT_STATE.NEUTRAL;
    }
    @Override
    public void tick() {
        if (migrationCounter > 0) {
            migrate();
            migrationCounter--;
            return;
        }

        if(matingSeason) {
           if(energy < 100) hunt();
           else {
               migrationCounter = 10;
               migrate();
           }
        } else if (energy < 40) {
           hunt();
        } else if (energy < 60) {
           roam();
        } else {
           socialize();
        }
    }

    public int getPackSize() {
        return packSize;
    }

    public void setPackSize(int packSize) {
        this.packSize = packSize;
    }

    public boolean isMatingSeason() {
        return matingSeason;
    }

    public void setMatingSeason(boolean matingSeason) {
        this.matingSeason = matingSeason;
    }
}
