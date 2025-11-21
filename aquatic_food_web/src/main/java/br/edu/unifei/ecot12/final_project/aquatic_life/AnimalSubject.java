package br.edu.unifei.ecot12.final_project.aquatic_life;

import java.util.ArrayList;
import java.util.List;

public abstract class AnimalSubject extends Animal implements ISubject {
    private List<IObserver> observers = new ArrayList<>();

    public void attach(IObserver o) {
        observers.add(o);
    }

    public void detach(IObserver o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (IObserver o : observers) {
            o.update(this);
        }
    }

    public List<IObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<IObserver> observers) {
        this.observers = observers;
    }
    
}
