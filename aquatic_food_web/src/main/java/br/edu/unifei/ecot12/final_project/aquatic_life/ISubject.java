package br.edu.unifei.ecot12.final_project.aquatic_life;

public interface ISubject {
    public void attach(IObserver o);
    public void detach(IObserver o);
    public void notifyObservers();
    public SUBJECT_STATE getState();
}
