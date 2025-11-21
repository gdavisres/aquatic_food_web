package br.edu.unifei.ecot12.final_project.aquatic_life;

import java.util.ArrayList;
import java.util.List;

public final class Ecosystem {
    private static Ecosystem instance;
    private List<AquaticLife> organisms = new ArrayList<>();
    private GLOBAL_EVENT currentEvent;
    private Ecosystem(){}
    public static Ecosystem getInstance(){
        if (instance == null) {
            instance = new Ecosystem();
        }
        return instance;
    }
    public void triggerGlobalEvent(GLOBAL_EVENT event){
        this.currentEvent = event;
        for(AquaticLife life : organisms){
            if(life instanceof Orca) {
                ((Orca)life).setMatingSeason(event == GLOBAL_EVENT.MATING_SEASON);
            }
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
    
    public <T> T findOrganism(Class<T> type) {
        for(AquaticLife life : organisms) {
            if(type.isInstance(life)) {
                return type.cast(life);
            }
            // Also check inside groups like KelpForest
            if(life instanceof AquaticLifeGroup) {
                for(AquaticLife child : ((AquaticLifeGroup)life).getChildren()) {
                    if(type.isInstance(child)) {
                        return type.cast(child);
                    }
                }
            }
        }
        return null;
    }

    public GLOBAL_EVENT getCurrentEvent() {
        return currentEvent;
    }
}
