package components;

import shops.Shop;

import java.net.URL;
import java.util.ArrayList;

public class HardDrive extends Component {

    //Class variables
    //HddCompatibilityInfo
    private String useType;
    //HddGeneralInfo
    private int capacity;
    private String communicationProtocol;
    private boolean hybrid;
    //HddPerformanceInfo
    private int rotationSpeed;
    private int cacheSize;
    //HddDimensionsInfo
    private String formfactor;


    //Constructors
    public HardDrive(Object[] specs){
        super((String)specs[0]);
        super.setComponentLink((String) specs[1]);

        int counter = 2;
        this.useType = (String) specs[counter++];
        this.capacity = (int) specs[counter++];
        this.communicationProtocol = (String) specs[counter++];
        this.hybrid = (Boolean) specs[counter++];
        this.rotationSpeed = (int) specs[counter++];
        this.cacheSize = (int) specs[counter++];
        this.formfactor = (String) specs[counter++];
        super.setAverageReview((Double) specs[counter++]);
        setStoreDetails((Object[]) specs[counter]);
    }


    //Setters and Getters
    public String getUseType() {
        return useType;
    }
    public void setUseType(String useType) {
        this.useType = useType;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCommunicationProtocol() {
        return communicationProtocol;
    }
    public void setCommunicationProtocol(String communicationProtocol) {
        this.communicationProtocol = communicationProtocol;
    }

    public boolean isHybrid() {
        return hybrid;
    }
    public void setHybrid(boolean hybrid) {
        this.hybrid = hybrid;
    }

    public int getRotationSpeed() {
        return rotationSpeed;
    }
    public void setRotationSpeed(int rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public int getCacheSize() {
        return cacheSize;
    }
    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public String getFormfactor() {
        return formfactor;
    }
    public void setFormfactor(String formfactor) {
        this.formfactor = formfactor;
    }


    //Other Methods
    @Override
    public void buildScore() {

    }

    public Object[] buildSpecArray() {
        ArrayList<Object> specs = new ArrayList<>();
        specs.add(getName());
        specs.add(getComponentLink());
        specs.add(getUseType());
        specs.add(getCapacity());
        specs.add(getCommunicationProtocol());
        specs.add(isHybrid());
        specs.add(getRotationSpeed());
        specs.add(getCacheSize());
        specs.add(getFormfactor());
        specs.add(getAverageReview());
        specs.add(getStoreDetails());
        return specs.toArray();
    }
}
