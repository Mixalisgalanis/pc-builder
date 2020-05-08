package components;

import java.util.ArrayList;

public class Processor extends Component {

    //Class variables
    //CpuInfo
    private String family;
    private int cores;
    private int threads;
    private int baseClockSpeed;
    private String architecture;
    private String socket;
    private boolean is64bit;
    private int TDP;
    private String onboardGraphics;
    private String cpuPackage;


    //Constructors
    public Processor(Object[] specs){
        super((String)specs[0]);
        super.setComponentLink((String) specs[1]);

        int counter = 2;
        this.family = (String) specs[counter++];
        this.cores = (int) specs[counter++];
        this.threads = (int) specs[counter++];
        this.baseClockSpeed = (int) specs[counter++];
        this.architecture = (String) specs[counter++];
        this.socket = (String) specs[counter++];
        this.is64bit = (boolean) specs[counter++];
        this.TDP =  (int) specs[counter++];
        this.onboardGraphics = (String) specs[counter++];
        this.cpuPackage = (String) specs[counter++];
        super.setAverageReview((Double) specs[counter++]);
        setStoreDetails((Object[]) specs[counter]);
    }

    //Setters and Getters

    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }

    public int getCores() {
        return cores;
    }
    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getThreads() {
        return threads;
    }
    public void setThreads(int threads) {
        this.threads = threads;
    }

    public int getBaseClockSpeed() {
        return baseClockSpeed;
    }
    public void setBaseClockSpeed(int baseClockSpeed) {
        this.baseClockSpeed = baseClockSpeed;
    }

    public String getArchitecture() {
        return architecture;
    }
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getSocket() {
        return socket;
    }
    public void setSocket(String socket) {
        this.socket = socket;
    }

    public boolean isIs64bit() {
        return is64bit;
    }
    public void setIs64bit(boolean is64bit) {
        this.is64bit = is64bit;
    }

    public int getTDP() {
        return TDP;
    }
    public void setTDP(int TDP) {
        this.TDP = TDP;
    }

    public String getOnboardGraphics() {
        return onboardGraphics;
    }
    public void setOnboardGraphics(String onboardGraphics) {
        this.onboardGraphics = onboardGraphics;
    }

    public String getCpuPackage() {
        return cpuPackage;
    }
    public void setCpuPackage(String cpuPackage) {
        this.cpuPackage = cpuPackage;
    }

    //Other Methods
    @Override
    public void buildScore() {

    }

    public Object[] buildSpecArray() {
        ArrayList<Object> specs = new ArrayList<>();
        specs.add(getName());
        specs.add(getComponentLink());
        specs.add(getFamily());
        specs.add(getCores());
        specs.add(getThreads());
        specs.add(getBaseClockSpeed());
        specs.add(getArchitecture());
        specs.add(getSocket());
        specs.add(isIs64bit());
        specs.add(getTDP());
        specs.add(getOnboardGraphics());
        specs.add(getCpuPackage());
        specs.add(getAverageReview());
        specs.add(getStoreDetails());
        return specs.toArray();
    }
}
