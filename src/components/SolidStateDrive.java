package components;

import java.util.ArrayList;

public class SolidStateDrive extends Component {

    //Class variables
    //SsdGeneralInfo
    private int capacity;
    private String communicationProtocol;
    //SsdPerformanceInfo
    private int readSpeed;
    private int writeSpeed;
    private int max4KRandomWrite;
    //SsdDimensionsInfo
    private String formfactor;


    //Constructors
    public SolidStateDrive(Object[] specs) {
        super((String) specs[0]);
        super.setComponentLink((String) specs[1]);

        int counter = 2;
        this.capacity = (int) specs[counter++];
        this.communicationProtocol = (String) specs[counter++];
        this.readSpeed = (int) specs[counter++];
        this.writeSpeed = (int) specs[counter++];
        this.max4KRandomWrite = (int) specs[counter++];
        this.formfactor = (String) specs[counter++];
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

    public String getCommunicationProtocol() {
        return communicationProtocol;
    }

    public void setCommunicationProtocol(String communicationProtocol) {
        this.communicationProtocol = communicationProtocol;
    }

    public int getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(int readSpeed) {
        this.readSpeed = readSpeed;
    }

    public int getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(int writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    public int getMax4KRandomWrite() {
        return max4KRandomWrite;
    }

    public void setMax4KRandomWrite(int max4KRandomWrite) {
        this.max4KRandomWrite = max4KRandomWrite;
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
        specs.add(getCapacity());
        specs.add(getCommunicationProtocol());
        specs.add(getReadSpeed());
        specs.add(getWriteSpeed());
        specs.add(getMax4KRandomWrite());
        specs.add(getFormfactor());
        specs.add(getAverageReview());
        specs.add(getStoreDetails());
        return specs.toArray();
    }
}
