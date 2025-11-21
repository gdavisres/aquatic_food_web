package br.edu.unifei.ecot12.final_project.aquatic_life;

public class SeaTurtle extends Animal implements IObserver, IHerbivore {
    private int shellHardness;
    private boolean isHidingInShell;

    @Override
    public void update(ISubject s) {
        if(s.getState() == SUBJECT_STATE.HUNTING) {
            hideInShell();
        } else {
            // graze(); 
            isHidingInShell = false;
        }
    }

    public void hideInShell() {
        isHidingInShell = true;
        System.out.println(getName() + " is HIDING in shell! Hardness: " + shellHardness);
    }

    @Override
    public void graze(Kelp plant) {
        System.out.println(getName() + " is GRAZING on " + plant.getName());
        plant.setBiomass(plant.getHeight() - 1);
        this.energy += 5;
    }

    @Override
    public void tick() {
        if(isHidingInShell) {
            System.out.println(getName() + " is waiting inside shell.");
        } else {
            // Try to find kelp to eat
            Kelp kelp = Ecosystem.getInstance().findOrganism(Kelp.class);
            if(kelp != null) {
                graze(kelp);
            } else {
                System.out.println(getName() + " is swimming slowly (no kelp found).");
            }
        }
    }

    public int getShellHardness() {
        return shellHardness;
    }

    public void setShellHardness(int shellHardness) {
        this.shellHardness = shellHardness;
    }

    public boolean isHidingInShell() {
        return isHidingInShell;
    }

    public void setHidingInShell(boolean hidingInShell) {
        isHidingInShell = hidingInShell;
    }
}
