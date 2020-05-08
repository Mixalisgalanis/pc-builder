package components;

import java.util.ArrayList;

public class Ram extends Component {

    //Class variables
    //RamGeneralInfo
    private int capacity;
    private String type;
    private int clockSpeed;
    private String useType;
    //RamOtherInfo
    private int modules;
    private int casLatency;


    //Constructors
    public Ram(Object[] specs) {
        super((String) specs[0]);
        super.setComponentLink((String) specs[1]);

        int counter = 2;
        this.capacity =(int) specs[counter++];
        this.type =(String) specs[counter++];
        this.clockSpeed = (int) specs[counter++];
        this.useType =(String) specs[counter++];
        this.modules = (int) specs[counter++];
        this.casLatency = (int) specs[counter++];
        super.setAverageReview((Double) specs[counter++]);
        setStoreDetails((Object[]) specs[counter]);
    }


    //Setters and Getters

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public int getModules() {
        return modules;
    }

    public void setModules(int modules) {
        this.modules = modules;
    }

    public int getCasLatency() {
        return casLatency;
    }

    public void setCasLatency(int casLatency) {
        this.casLatency = casLatency;
    }

    //Other Methods
    @Override
    public void buildScore() {

    }

    public Object[] buildSpecArray() {
        ArrayList<Object> specs = new ArrayList<>();
        specs.add(getName());
        specs.add(getComponentLink());
        specs.add(getCapacity());
        specs.add(getType());
        specs.add(getClockSpeed());
        specs.add(getUseType());
        specs.add(getModules());
        specs.add(getCasLatency());
        specs.add(getAverageReview());
        specs.add(getStoreDetails());
        return specs.toArray();
    }
}
