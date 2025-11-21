package br.edu.unifei.ecot12.final_project.aquatic_life;

public abstract class Organism implements AquaticLife {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
