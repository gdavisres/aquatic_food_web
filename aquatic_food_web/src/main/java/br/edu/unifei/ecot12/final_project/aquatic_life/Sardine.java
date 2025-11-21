package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Sardine extends Animal {
    private double weight;
    private boolean isFleeing;

    public void flee(){
        this.isFleeing = true;
        // System.out.println(getName() + " is FLEEING!"); // Output handled by SchoolOfFish
    }
    public void forage(){
        // System.out.println(getName() + " is foraging for food."); // Output handled by SchoolOfFish
        // Logic: Eat Kelp if available
        Kelp kelp = Ecosystem.getInstance().findOrganism(Kelp.class);
        if(kelp != null) {
            kelp.setBiomass(kelp.getHeight() - 0.1);
            this.energy += 1;
        }
    }
    public void tick(){
        weight++;
        if(!isFleeing){
            forage();
        }
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public boolean isFleeing() {
        return isFleeing;
    }
    public void setFleeing(boolean fleeing) {
        isFleeing = fleeing;
    }
}
