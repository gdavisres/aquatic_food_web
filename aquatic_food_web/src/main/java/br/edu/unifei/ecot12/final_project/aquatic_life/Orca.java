package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Orca extends AnimalSubject {
    public enum ORCA_STATE { HUNTING, SOCIALIZING, MIGRATING, ROAMING }
    private ORCA_STATE currentState;
    private int packSize;
    private boolean matingSeason;

    public void hunt() {
        currentState = ORCA_STATE.HUNTING;
        notifyObservers();
    }
    public void socialize() {
        currentState = ORCA_STATE.SOCIALIZING;
    }
    public void migrate() {
        currentState = ORCA_STATE.MIGRATING;
    }
    public void roam() {
        currentState = ORCA_STATE.ROAMING;
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
        if(matingSeason) {
           if(energy < 100) hunt();
           else migrate();
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
