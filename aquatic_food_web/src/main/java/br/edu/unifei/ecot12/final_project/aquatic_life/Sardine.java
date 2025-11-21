package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Sardine extends Animal implements IHerbivore {
    private double weight;
    private boolean isFleeing;
    public Sardine(double size, double weight) {
        this.size = size;
        this.weight = weight;
        this.energy = 50;
        this.isFleeing = false;
    }
    public void flee(){
        this.isFleeing = true;
    }
    public void forage(){
        this.isFleeing = false;
        graze(new Kelp(5.0) );
    }
    public void tick(){
        if(!isFleeing){
            forage();
        }
    }
    @Override
    public void graze(Kelp plant) {
        if(plant.getHeight() > 0){
            plant.setHeight(plant.getHeight() - 1);
            this.energy += 10;
            this.weight += 0.5;
            System.out.println(this.getName() + " is grazing on " + plant.getName());
        }
    }
}
