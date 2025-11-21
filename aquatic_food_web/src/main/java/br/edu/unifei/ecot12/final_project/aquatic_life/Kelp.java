package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Kelp extends Organism{
    private double height;
    private double biomass;
    
    public void photosynthesis(){
        height += 2.0;
        biomass = height * 0.5;
        System.out.println(getName() + " is PHOTOSYNTHESIZING. Biomass: " + biomass);
    }
    public void tick(){
        photosynthesis();
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
