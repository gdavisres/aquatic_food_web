package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Kelp extends Organism{
    private double height;
    private double biomass;
    
    public Kelp(double height) {
        this.height = height;
        this.biomass = height * 2;
    }

    public void photosynthesize(){
        System.out.println(this.getName() + " is photosynthesizing.");   
        height += 0.5;
        biomass += 1.0;
    }
    public void tick(){
        photosynthesize();
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getBiomass() {
        return biomass;
    }
    public void setBiomass(double biomass) {
        this.biomass = biomass;
    }
    
}
