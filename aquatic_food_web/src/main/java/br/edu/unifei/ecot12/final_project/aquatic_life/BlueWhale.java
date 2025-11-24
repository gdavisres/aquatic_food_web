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
                p.setDensity(p.getDensity() - 5);
            }
        }
    }

    public void surface() {
        oxygen = 100;
        System.out.println(getName() + " surfaced for air.");
    }

    @Override
    public void filterFeed(PlanktonBloom bloom) {
        isFeeding = true;
        energy += 20;
        System.out.println(getName() + " is FILTER FEEDING on plankton bloom. Energy: " + energy);
    }

    @Override
    public void tick() {
        oxygen -= 10;
        energy -= 5;

        if(oxygen < 10) surface();

        else if(energy <= 50) {
            System.out.println(getName() + " is feeding...");
            filterFeed(null);
        }
        else System.out.println(getName() + " is swimming majestically. Energy: " + energy + ", Oxygen: " + oxygen);
        
        isFeeding = false; // Reset feeding state for next tick
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
