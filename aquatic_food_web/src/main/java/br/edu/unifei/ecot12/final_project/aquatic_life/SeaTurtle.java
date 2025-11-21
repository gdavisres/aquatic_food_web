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
    }

    @Override
    public void graze(Kelp plant) {
        // Graze logic
    }

    @Override
    public void tick() {
        // Tick logic
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
