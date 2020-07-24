package alnsFF;

public class ALNSSettings {

    private int seed;
    private int maxGen;
    private int numOfServices;
    private int tabuSize;
    private int improvementThreshold;
    private Initialization initialization;
    private ReplicaPatternDestroy replicaPatternDestroy;
    private AllocationDestroy allocationDestroy;
    private ALNSCollector collector;


    public ALNSSettings(
            int seed,
            int maxGen,
            int numOfServices,
            int tabuSize,
            int improvementThreshold,
            Initialization initialization,
            ReplicaPatternDestroy replicaPatternDestroy,
            AllocationDestroy allocationDestroy,
            ALNSCollector collector
    ){
        this.seed = seed;
        this.maxGen = maxGen;
        this.numOfServices = numOfServices;
        this.tabuSize = tabuSize;
        this.improvementThreshold = improvementThreshold;
        this.initialization = initialization;
        this.replicaPatternDestroy = replicaPatternDestroy;
        this.allocationDestroy = allocationDestroy;
        this.collector = collector;
    }

    public int getTabuSize() {
        return tabuSize;
    }

    public int getMaxGen() {
        return maxGen;
    }

    public int getNumOfServices() {
        return numOfServices;
    }

    public int getImprovementThreshold() {
        return improvementThreshold;
    }

    public Initialization getInitialization() {
        return initialization;
    }

    public ReplicaPatternDestroy getReplicaPatternDestroy() {
        return replicaPatternDestroy;
    }

    public AllocationDestroy getAllocationDestroy() {
        return allocationDestroy;
    }

    public ALNSCollector getCollector() {
        return collector;
    }

    public int getSeed() {
        return seed;
    }
}
