package br.edu.unifei.ecot12.final_project.aquatic_life;

import java.util.ArrayList;
import java.util.List;

public abstract class AquaticLifeGroup {
    private List<AquaticLife> children;
    private List<AquaticLife> collection = 
        new ArrayList<>();
    public void add(AquaticLife life){
        collection.add(life);
    }
    public void remove(AquaticLife life){
        collection.remove(life);
    }
    public void tick(){
        for(AquaticLife a : collection){
            a.tick();
        }
    }
    public List<AquaticLife> getChildren() {
        return children;
    }
    public void setChildren(List<AquaticLife> children) {
        this.children = children;
    }
    public List<AquaticLife> getCollection() {
        return collection;
    }
    public void setCollection(List<AquaticLife> collection) {
        this.collection = collection;
    }
    
}
