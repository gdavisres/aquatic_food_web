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
        
        // 1. Create Subjects (Predators/Proactive)
        GreatWhiteShark shark = new GreatWhiteShark();
        shark.setName("Jaws, the Shark");
        shark.setEnergy(100);
        ecosystem.addOrganism(shark);

        Orca orca = new Orca();
        orca.setName("Willy, the Orca");
        orca.setEnergy(100);
        orca.setPackSize(5);
        ecosystem.addOrganism(orca);

        Dolphin dolphin = new Dolphin();
        dolphin.setName("Flipper, the Dolphin");
        dolphin.setEnergy(60);
        ecosystem.addOrganism(dolphin);

        PlanktonBloom bloom = new PlanktonBloom();
        bloom.setName("Red Tide, the Plankton Bloom");
        ecosystem.addOrganism(bloom);

        // 2. Create Observers (Prey/Reactive)
        SchoolOfFish school = new SchoolOfFish();
        // school.setName("Sardine School");
        
        for(int i=0; i<5; i++) {
            Sardine s = new Sardine();
            s.setName("Sardine " + i);
            school.add(s);
        }
        ecosystem.addOrganism(school);

        Seal seal = new Seal();
        seal.setName("Sammy, the Seal");
        seal.setEscapeSpeed(20.0);
        ecosystem.addOrganism(seal);

        Tuna tuna = new Tuna();
        tuna.setName("Charlie, the Tuna");
        tuna.setSwimmingSpeed(25.0);
        tuna.setStamina(100);
        tuna.setEnergy(100);
        ecosystem.addOrganism(tuna);

        BlueWhale whale = new BlueWhale();
        whale.setName("Big Blue, the Blue Whale");
        whale.setEnergy(100);
        whale.setOxygen(100);
        ecosystem.addOrganism(whale);

        SeaTurtle turtle = new SeaTurtle();
        turtle.setName("Crush, the Sea Turtle");
        turtle.setShellHardness(50);
        ecosystem.addOrganism(turtle);

        CleanerWrasse wrasse = new CleanerWrasse();
        wrasse.setName("Doc, the Cleaner Wrasse");
        ecosystem.addOrganism(wrasse);

        // 3. Create Environment
        KelpForest forest = new KelpForest();
        // forest.setName("Kelp Forest");
        Kelp kelp1 = new Kelp();
        kelp1.setName("Kelp 1");
        kelp1.setHeight(10);
        forest.add(kelp1);
        ecosystem.addOrganism(forest);

        // 4. Attach Observers to Subjects
        // shark.attach(school);
        shark.attach(seal);
        shark.attach(tuna);
        shark.attach(turtle);
        shark.attach(wrasse);
        shark.attach(dolphin);

        orca.attach(seal);
        orca.attach(tuna);
        orca.attach(dolphin);

        dolphin.attach(school);
        
        bloom.attach(whale); // Whale observes bloom
    }
    public void runLoop(){
        int cycles = 0;
        while(cycles < 20){ 
            System.out.println("\n--- Cycle " + cycles + " ---");
            
            // Randomly trigger global events
            if(cycles == 5) {
                System.out.println(">>> EVENT: MATING SEASON <<<");
                ecosystem.triggerGlobalEvent(GLOBAL_EVENT.MATING_SEASON);
            }
            if(cycles == 10) {
                System.out.println(">>> EVENT: MATING SEASON ENDED<<<");
                ecosystem.triggerGlobalEvent(GLOBAL_EVENT.NONE);
            }
            if(cycles == 15) {
                System.out.println(">>> EVENT: STORM <<<");
                ecosystem.triggerGlobalEvent(GLOBAL_EVENT.STORM);
            }
            if(cycles == 18) {
                System.out.println(">>> EVENT: STORM ENDED <<<");
                ecosystem.triggerGlobalEvent(GLOBAL_EVENT.NONE);
            }

            for(int i = 0; i < ecosystem.getOrganisms().size(); i++){
                ecosystem.getOrganisms().get(i).tick();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cycles++;
        }
    }
}
