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
        
        GreatWhiteShark shark = new GreatWhiteShark();
        shark.setName("Jaws");
        shark.setEnergy(100);
        ecosystem.addOrganism(shark);

        SchoolOfFish school = new SchoolOfFish();
        // school.setName("Sardine School");
        
        for(int i=0; i<10; i++) {
            Sardine s = new Sardine();
            s.setName("Sardine " + i);
            school.add(s);
        }
        ecosystem.addOrganism(school);
        
        // Observer pattern wiring
        shark.attach(school);
    }
    public void runLoop(){
        int cycles = 0;
        while(cycles < 50){ // Run for 50 cycles for demo
            System.out.println("--- Cycle " + cycles + " ---");
            for(int i = 0; i < ecosystem.getOrganisms().size(); i++){
                ecosystem.getOrganisms().get(i).tick();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cycles++;
        }
    }
}
