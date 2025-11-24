package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Sardine extends Animal {
    private double weight;
    private boolean isFleeing = false;

    public void flee(){
        this.isFleeing = true;
        // System.out.println(getName() + " is FLEEING!");
        // Output handled by SchoolOfFish
    }
    public void forage(){
        // System.out.println(getName() + " is FORAGING for plankton.");
        // Output handled by SchoolOfFish
        weight += 0.1;
    }
    public void tick(){
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
