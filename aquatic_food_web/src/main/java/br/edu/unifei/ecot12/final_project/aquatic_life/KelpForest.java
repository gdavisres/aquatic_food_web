package br.edu.unifei.ecot12.final_project.aquatic_life;

public class KelpForest extends AquaticLifeGroup {
    private double density;
    private double area;

    public boolean canProvideShelter(Organism animal) {
        if (animal instanceof Animal) {
            return this.density > 0.7 && ((Animal)animal).getSize() < (this.area / 2);
        }
        return false;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
