package br.edu.unifei.ecot12.final_project.aquatic_life;

public class GreatWhiteShark extends AnimalSubject {
    public enum SHARK_STATE { HUNTING, RESTING, ROAMING }
    private SHARK_STATE currentState;
    private double speed;

    public void hunt() {
        currentState = SHARK_STATE.HUNTING;
        System.out.println(getName() + " is HUNTING! Energy: " + energy);
        energy -= 10;
        
        // Chance to eat and regain energy
        if(Math.random() > 0.5) {
            System.out.println(">>> " + getName() + " CAUGHT PREY! Energy restored. <<<");
            energy += 40;
            if(energy > 100) energy = 100;
        }
        
        notifyObservers();
    }
    public void rest() {
        currentState = SHARK_STATE.RESTING;
        System.out.println(getName() + " is RESTING. Energy: " + energy);
        energy -= 2; // Metabolism burns energy even when resting
    }
    public void roam() {
        currentState = SHARK_STATE.ROAMING;
        System.out.println(getName() + " is ROAMING. Energy: " + energy);
        energy -= 5;
    }
    public void setState(SHARK_STATE newState) {
        this.currentState = newState;
    }
    @Override
    public SUBJECT_STATE getState() {
        if (currentState == SHARK_STATE.HUNTING) return SUBJECT_STATE.HUNTING;
        if (currentState == SHARK_STATE.RESTING) return SUBJECT_STATE.PASSIVE;
        return SUBJECT_STATE.NEUTRAL;
    }
    @Override
    public void tick() {
        if(energy < 60) hunt();
        else if(energy < 80) roam();
        else rest();
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
