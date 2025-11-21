package br.edu.unifei.ecot12.final_project.aquatic_life;

import java.util.List;

public abstract class AnimalSubject extends Animal implements ISubject {
    private List<IObserver> observers;

    public List<IObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<IObserver> observers) {
        this.observers = observers;
    }
    
}
