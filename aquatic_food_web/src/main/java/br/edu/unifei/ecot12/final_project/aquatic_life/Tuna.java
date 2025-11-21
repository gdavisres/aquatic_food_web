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
        System.out.println(getName() + " is swimming away FAST! Speed: " + swimmingSpeed);
        stamina -= 10;
    }

    @Override
    public void tick() {
        if(stamina < 100) stamina++;
        
        // Tuna needs to eat too to maintain energy (simulated by stamina here or separate energy)
        // Let's say it hunts sardines
        Sardine sardine = Ecosystem.getInstance().findOrganism(Sardine.class);
        if(sardine != null && Math.random() > 0.7) {
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
