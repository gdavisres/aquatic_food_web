package br.edu.unifei.ecot12.final_project.aquatic_life;

import java.util.List;

public final class Ecosystem {
    private static Ecosystem instance;
    private List<AquaticLife> organisms;
    private GLOBAL_EVENT currentEvent;
    private Ecosystem(){}
    public static Ecosystem getInstance(){
        if (instance == null) {
            instance = new Ecosystem();
        }
        return instance;
    }
    public void TriggerGlobalEvent(GLOBAL_EVENT event){
        this.currentEvent = event;
        for(AquaticLife life : organisms){
            
        }
    }
    public void addOrganism(AquaticLife life){
        organisms.add(life);
    }
    public void removeOrganism(AquaticLife life){
        organisms.remove(life);
    }
    public List<AquaticLife> getOrganisms(){
        return organisms;
    }
}
