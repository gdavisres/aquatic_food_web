package br.edu.unifei.ecot12.final_project.aquatic_life;

public class CleanerWrasse extends Animal implements IObserver, ICarnivore {
    private boolean isCleaning;

    @Override
    public void update(ISubject s) {
        if (s.getState() == SUBJECT_STATE.PASSIVE) {
            if (s instanceof Animal) {
                clean((Animal)s);
            }
        } else if (s.getState() == SUBJECT_STATE.HUNTING) {
            hide();
        }
    }

    public void clean(Animal target) {
        isCleaning = true;
        System.out.println(getName() + " is CLEANING " + target.getName() + "'s teeth/scales.");
        // Symbiosis: Target gains energy/health, Wrasse gains food
        target.setEnergy(target.getEnergy() + 5);
        this.energy += 5;
    }

    public void hide() {
        isCleaning = false;
        System.out.println(getName() + " is HIDING from predator.");
    }

    @Override
    public void eat(Animal a) {
        System.out.println(getName() + " is eating parasites from " + a.getName());
    }

    @Override
    public void tick() {
        if(!isCleaning) {
            System.out.println(getName() + " is looking for a client.");
        }
        isCleaning = false; // Reset
    }

    public boolean isCleaning() {
        return isCleaning;
    }

    public void setCleaning(boolean cleaning) {
        isCleaning = cleaning;
    }
}
