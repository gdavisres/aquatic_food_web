package br.edu.unifei.ecot12.final_project.aquatic_life;

public class SchoolOfFish extends AquaticLifeGroup implements IObserver {

    @Override
    public void update(ISubject s) {
        scatter();
    }

    public void scatter() {
        System.out.println("The " + getChildren().size() + " sardines in the school are SCATTERING!");
        for(AquaticLife life : getChildren()) {
            if(life instanceof Sardine) {
                ((Sardine)life).flee();
            }
        }
    }

    @Override
    public void tick() {
        super.tick(); // Updates individual sardines (weight++, state)
        
        // Check state of one to determine group state for output
        if(!getChildren().isEmpty() && getChildren().get(0) instanceof Sardine) {
            Sardine s = (Sardine) getChildren().get(0);
            if(!s.isFleeing()) {
                System.out.println("The school of " + getChildren().size() + " sardines is foraging peacefully.");
            }
        }
    }
}
