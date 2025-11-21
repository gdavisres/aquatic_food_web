package br.edu.unifei.ecot12.final_project.aquatic_life;

public class BlueWhale extends Animal implements IObserver, IFilterFeeder {
    private boolean isFeeding;
    private int oxygen;

    @Override
    public void update(ISubject s) {
        if(s instanceof PlanktonBloom) {
            PlanktonBloom p = (PlanktonBloom) s;
            if(p.getDensity() > 5) {
                filterFeed(p);
            }
        }
    }

    public void surface() {
        oxygen = 100;
    }

    @Override
    public void filterFeed(PlanktonBloom bloom) {
        isFeeding = true;
        // Feed logic
    }

    @Override
    public void tick() {
        // Tick logic
    }

    public boolean isFeeding() {
        return isFeeding;
    }

    public void setFeeding(boolean feeding) {
        isFeeding = feeding;
    }

    public int getOxygen() {
        return oxygen;
    }

    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }
}
