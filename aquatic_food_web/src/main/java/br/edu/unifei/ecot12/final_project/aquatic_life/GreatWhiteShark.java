package br.edu.unifei.ecot12.final_project.aquatic_life;

public class GreatWhiteShark extends AnimalSubject {
    public enum SHARK_STATE { HUNTING, RESTING, ROAMING }
    private SHARK_STATE currentState;
    private double speed;

    public void hunt() {
        currentState = SHARK_STATE.HUNTING;
        notifyObservers();
    }
    public void rest() {
        currentState = SHARK_STATE.RESTING;
    }
    public void roam() {
        currentState = SHARK_STATE.ROAMING;
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
