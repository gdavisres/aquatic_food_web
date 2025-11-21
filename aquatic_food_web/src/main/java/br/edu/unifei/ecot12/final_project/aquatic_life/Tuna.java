package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Tuna extends Animal implements IObserver {
    private double swimmingSpeed;
    private int stamina;

    @Override
    public void update(ISubject s) {
        if(s instanceof GreatWhiteShark || s instanceof Orca) {
            if (s.getState() == SUBJECT_STATE.HUNTING) {
                flee();
            }
        }
    }

    public void flee() {
        // Flee logic
    }

    @Override
    public void tick() {
        // Tick logic
    }

    public double getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(double swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
