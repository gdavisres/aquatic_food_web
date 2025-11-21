package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Seal extends Animal implements IObserver {
    private boolean isHidden;
    private double escapeSpeed;

    @Override
    public void update(ISubject s) {
        if (s.getState() == SUBJECT_STATE.HUNTING) {
            flee();
        }
    }

    public void flee() {
        isHidden = false;
        System.out.println(getName() + " is FLEEING to safety at speed " + escapeSpeed);
    }

    public void hide() {
        isHidden = true;
        System.out.println(getName() + " is HIDING.");
    }

    @Override
    public void tick() {
        if(isHidden) {
            System.out.println(getName() + " is staying hidden.");
        } else {
            System.out.println(getName() + " is swimming around.");
        }
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public double getEscapeSpeed() {
        return escapeSpeed;
    }

    public void setEscapeSpeed(double escapeSpeed) {
        this.escapeSpeed = escapeSpeed;
    }
}
