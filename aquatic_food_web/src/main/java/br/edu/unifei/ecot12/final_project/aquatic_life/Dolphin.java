package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Dolphin extends AnimalSubject implements IObserver {
    public enum DOLPHIN_STATE { HUNTING, FLEEING, PLAYING }
    private DOLPHIN_STATE currentState;
    private boolean isFleeing;

    public void huntForFish() {
        currentState = DOLPHIN_STATE.HUNTING;
        System.out.println(getName() + " is HUNTING for fish!");
        notifyObservers();
    }
    public void flee() {
        currentState = DOLPHIN_STATE.FLEEING;
        isFleeing = true;
        System.out.println(getName() + " is FLEEING from danger!");
    }
    public void play() {
        currentState = DOLPHIN_STATE.PLAYING;
        isFleeing = false;
        System.out.println(getName() + " is PLAYING happily.");
    }
    public void setState(DOLPHIN_STATE newState) {
        this.currentState = newState;
    }
    @Override
    public SUBJECT_STATE getState() {
        if (currentState == DOLPHIN_STATE.HUNTING) return SUBJECT_STATE.HUNTING;
        if (currentState == DOLPHIN_STATE.FLEEING) return SUBJECT_STATE.FLEEING;
        return SUBJECT_STATE.NEUTRAL;
    }
    @Override
    public void update(ISubject s) {
        if (s.getState() == SUBJECT_STATE.HUNTING) {
            flee();
        }
    }
    @Override
    public void tick() {
        if(!isFleeing) play();
    }

    public boolean isFleeing() {
        return isFleeing;
    }

    public void setFleeing(boolean fleeing) {
        isFleeing = fleeing;
    }
}
