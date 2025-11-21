package br.edu.unifei.ecot12.final_project.aquatic_life;

public class SchoolOfFish extends AquaticLifeGroup implements IObserver {

    @Override
    public void update(ISubject s) {
        scatter();
    }

    public void scatter() {
        for(AquaticLife life : getChildren()) {
            if(life instanceof Sardine) {
                ((Sardine)life).flee();
            }
        }
    }
}
