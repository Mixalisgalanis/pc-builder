package components;

import java.util.ArrayList;

public class PowerSupply extends Component {

    //Class variables
    //PsuInfo
    private int wattage;
    private String pfcType;
    private String formfactor;
    private String modularity;
    private String certification;
    private int fanSize;
    private String protections;
    private String extras;


    //Constructors
    public PowerSupply(Object[] specs) {
        super((String) specs[0]);
        super.setComponentLink((String) specs[1]);

        int counter = 2;
        this.wattage = (int) specs[counter++];
        this.pfcType = (String) specs[counter++];
        this.formfactor = (String) specs[counter++];
        this.modularity = (String) specs[counter++];
        this.certification = (String) specs[counter++];
        this.fanSize = (int) specs[counter++];
        this.protections = (String) specs[counter++];
        this.extras = (String) specs[counter++];
        super.setAverageReview((Double) specs[counter++]);
        setStoreDetails((Object[]) specs[counter]);
    }


    //Setters and Getters

    public int getWattage() {
        return wattage;
    }
    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public String getPfcType() {
        return pfcType;
    }
    public void setPfcType(String pfcType) {
        this.pfcType = pfcType;
    }

    public String getFormfactor() {
        return formfactor;
    }
    public void setFormfactor(String formfactor) {
        this.formfactor = formfactor;
    }

    public String getModularity() {
        return modularity;
    }
    public void setModularity(String modularity) {
        this.modularity = modularity;
    }

    public String getCertification() {
        return certification;
    }
    public void setCertification(String certification) {
        this.certification = certification;
    }

    public int getFanSize() {
        return fanSize;
    }
    public void setFanSize(int fanSize) {
        this.fanSize = fanSize;
    }

    public String getProtections() {
        return protections;
    }
    public void setProtections(String protections) {
        this.protections = protections;
    }

    public String getExtras() {
        return extras;
    }
    public void setExtras(String extras) {
        this.extras = extras;
    }

    //Other Methods
    @Override
    public void buildScore() {

    }

    public Object[] buildSpecArray() {
        ArrayList<Object> specs = new ArrayList<>();
        specs.add(getName());
        specs.add(getComponentLink());
        specs.add(getWattage());
        specs.add(getPfcType());
        specs.add(getFormfactor());
        specs.add(getModularity());
        specs.add(getCertification());
        specs.add(getFanSize());
        specs.add(getProtections());
        specs.add(getExtras());
        specs.add(getAverageReview());
        specs.add(getStoreDetails());
        return specs.toArray();
    }
}
