package components;

import shops.Shop;

import java.net.URL;
import java.util.ArrayList;

public class GraphicsCard extends Component {

    //Class variables
    //GpuGeneralInfo
    private String chipsetManufacturer;
    private String chipsetModel;
    private String busInterface;
    private int videoMemoryCapacity;
    private String memoryType;
    private String parallelComputing;
    private String other;
    //GpuTechnicalInfo
    private int baseClock;
    private int memoryClock;
    private String maxResolution;
    private String memoryBus;
    private int powerConsumption;
    //GpuConnectionsInfo
    private String displayConnections;
    private boolean dualLinkDVI;


    //Constructors
    public GraphicsCard(Object[] specs) {
        super((String) specs[0]);
        super.setComponentLink((String) specs[1]);

        int counter = 2;
        this.chipsetManufacturer = (String) specs[counter++];
        this.chipsetModel = (String) specs[counter++];
        this.busInterface = (String) specs[counter++];
        this.videoMemoryCapacity = (int) specs[counter++];
        this.memoryType = (String) specs[counter++];
        this.parallelComputing = (String) specs[counter++];
        this.other = (String) specs[counter++];
        this.baseClock = (int) specs[counter++];
        this.memoryClock = (int) specs[counter++];
        this.maxResolution = (String) specs[counter++];
        this.memoryBus = (String) specs[counter++];
        this.powerConsumption = (int) specs[counter++];
        this.displayConnections = (String) specs[counter++];
        this.dualLinkDVI = (boolean) specs[counter++];
        super.setAverageReview((Double) specs[counter++]);
        setStoreDetails((Object[]) specs[counter]);
    }


    //Setters and Getters
    public String getChipsetManufacturer() {
        return chipsetManufacturer;
    }

    public void setChipsetManufacturer(String chipsetManufacturer) {
        this.chipsetManufacturer = chipsetManufacturer;
    }

    public String getChipsetModel() {
        return chipsetModel;
    }

    public void setChipsetModel(String chipsetModel) {
        this.chipsetModel = chipsetModel;
    }

    public String getBusInterface() {
        return busInterface;
    }

    public void setBusInterface(String busInterface) {
        this.busInterface = busInterface;
    }

    public int getVideoMemoryCapacity() {
        return videoMemoryCapacity;
    }

    public void setVideoMemoryCapacity(int videoMemoryCapacity) {
        this.videoMemoryCapacity = videoMemoryCapacity;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getParallelComputing() {
        return parallelComputing;
    }

    public void setParallelComputing(String parallelComputing) {
        this.parallelComputing = parallelComputing;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public int getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(int baseClock) {
        this.baseClock = baseClock;
    }

    public int getMemoryClock() {
        return memoryClock;
    }

    public void setMemoryClock(int memoryClock) {
        this.memoryClock = memoryClock;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }

    public String getMemoryBus() {
        return memoryBus;
    }

    public void setMemoryBus(String memoryBus) {
        this.memoryBus = memoryBus;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getDisplayConnections() {
        return displayConnections;
    }

    public void setDisplayConnections(String displayConnections) {
        this.displayConnections = displayConnections;
    }

    public boolean isDualLinkDVI() {
        return dualLinkDVI;
    }

    public void setDualLinkDVI(boolean dualLinkDVI) {
        this.dualLinkDVI = dualLinkDVI;
    }


    //Other Methods
    @Override
    public void buildScore() {

    }

    @Override
    public Object[] buildSpecArray() {
        ArrayList<Object> specs = new ArrayList<>();
        specs.add(getName());
        specs.add(getComponentLink());
        specs.add(getChipsetManufacturer());
        specs.add(getChipsetModel());
        specs.add(getBusInterface());
        specs.add(getVideoMemoryCapacity());
        specs.add(getMemoryType());
        specs.add(getParallelComputing());
        specs.add(getOther());
        specs.add(getBaseClock());
        specs.add(getMemoryClock());
        specs.add(getMaxResolution());
        specs.add(getMemoryBus());
        specs.add(getPowerConsumption());
        specs.add(getDisplayConnections());
        specs.add(isDualLinkDVI());
        specs.add(getAverageReview());
        specs.add(getStoreDetails());
        return specs.toArray();
    }
}
