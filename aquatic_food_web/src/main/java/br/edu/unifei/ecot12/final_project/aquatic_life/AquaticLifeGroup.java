package br.edu.unifei.ecot12.final_project.aquatic_life;

import java.util.ArrayList;
import java.util.List;

public abstract class AquaticLifeGroup implements AquaticLife {
    private List<AquaticLife> children = new ArrayList<>();

    public void add(AquaticLife life){
        children.add(life);
    }
    public void remove(AquaticLife life){
        children.remove(life);
    }
    public void tick(){
        for(AquaticLife a : children){
            a.tick();
        }
    }
    public List<AquaticLife> getChildren() {
        return children;
    }
    public void setChildren(List<AquaticLife> children) {
        this.children = children;
    }
    
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
