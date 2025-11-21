package br.edu.unifei.ecot12.final_project.aquatic_life;

public class Simulation {
    public Ecosystem ecosystem;
    public static void main(String[] args) {
        Simulation sim = new Simulation();
        sim.setup();
        sim.runLoop();
    }
    public void setup(){
        ecosystem = Ecosystem.getInstance();
    }
    public void runLoop(){
        while(true){
            for(AquaticLife life : ecosystem.getOrganisms()){
                life.tick();
            }
        }
    }
}
