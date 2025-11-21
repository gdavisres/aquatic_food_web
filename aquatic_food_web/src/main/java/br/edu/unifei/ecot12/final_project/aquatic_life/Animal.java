package br.edu.unifei.ecot12.final_project.aquatic_life;

public abstract class Animal extends Organism {
    protected int energy;
    protected double size;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
