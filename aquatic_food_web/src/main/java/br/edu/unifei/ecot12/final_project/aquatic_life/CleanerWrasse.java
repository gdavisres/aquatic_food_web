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
        // Clean logic
    }

    public void hide() {
        isCleaning = false;
    }

    @Override
    public void eat(Animal a) {
        // Eat logic
    }

    @Override
    public void tick() {
        // Tick logic
    }

    public boolean isCleaning() {
        return isCleaning;
    }

    public void setCleaning(boolean cleaning) {
        isCleaning = cleaning;
    }
}
