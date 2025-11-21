package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Sardine extends Animal {
    private double weight;
    private boolean isFleeing;

    public void flee(){
        this.isFleeing = true;
    }
    public void forage(){
        // Forage logic
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
