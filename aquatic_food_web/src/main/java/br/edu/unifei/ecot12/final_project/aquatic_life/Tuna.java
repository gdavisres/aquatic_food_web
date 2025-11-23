package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Tuna extends Animal implements IObserver, ICarnivore {
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

    @Override
    public void eat(Animal a) {
        System.out.println(getName() + " ate a " + (a != null ? a.getName() : "prey") + "!");
        stamina += 20;
        if(stamina > 100) stamina = 100;
    }

    public void flee() {
        System.out.println(getName() + " is swimming away FAST! Speed: " + swimmingSpeed);
        stamina -= 10;
    }

    @Override
    public void tick() {
        if(stamina < 100) stamina++;
        
        if(Math.random() > 0.7) {
             System.out.println(getName() + " ate a Sardine!");
             stamina += 20;
             if(stamina > 100) stamina = 100;
        }

        System.out.println(getName() + " is swimming. Stamina: " + stamina);
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
