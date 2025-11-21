package br.edu.unifei.ecot12.final_project.aquatic_life;

public class PlanktonBloom extends AnimalSubject {
    private double density;

    public void grow() {
        density++;
        this.size++;
        notifyObservers();
    }

    public void dissipate() {
        density = 0;
        this.size = 0;
    }

    @Override
    public void tick() {
        grow();
    }

    @Override
    public SUBJECT_STATE getState() {
        return SUBJECT_STATE.NEUTRAL;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }
}
