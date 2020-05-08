package components;

import java.util.ArrayList;

public class Case extends Component {

    //Class variables
    //CaseDimensionsInfo
    private String size;
    private String supportedFormfactors;
    private int height;
    private int width;
    private int depth;
    private int maxGpuLength;
    //CaseDevicesInfo
    private int external5_25Slots;
    private int external3_5Slots;
    private int internal3_5Slots;
    private int internal2_5Slots;
    //CaseFansInfo
    private int frontFans;
    private int rearFans;
    private int sideFans;
    private int upperFans;
    private int bottomFans;
    //CaseLiquidCoolingInfo
    private String radiatorLocation;
    //CaseCapabilitiesInfo
    private String frontConnections;
    private String extras;
    private boolean gaming;


    //Constructor
    public Case(Object[] specs) {
        super((String)specs[0]);
        super.setComponentLink((String) specs[1]);

        int counter = 2;
        this.size = (String) specs[counter++];
        this.supportedFormfactors = (String) specs[counter++];
        this.height = (int) specs[counter++];
        this.width = (int) specs[counter++];
        this.depth = (int) specs[counter++];
        this.maxGpuLength = (int) specs[counter++];
        this.external5_25Slots = (int) specs[counter++];
        this.external3_5Slots = (int) specs[counter++];
        this.internal3_5Slots = (int) specs[counter++];
        this.internal2_5Slots = (int) specs[counter++];
        this.frontFans = (int) specs[counter++];
        this.rearFans = (int) specs[counter++];
        this.sideFans = (int) specs[counter++];
        this.upperFans = (int) specs[counter++];
        this.bottomFans = (int) specs[counter++];
        this.radiatorLocation = (String) specs[counter++];
        this.frontConnections = (String) specs[counter++];
        this.extras = (String) specs[counter++];
        this.gaming = (boolean) specs[counter++];
        super.setAverageReview((Double) specs[counter++]);
        setStoreDetails((Object[]) specs[counter]);
    }

    //Setters and Getters

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public String getSupportedFormfactors() {
        return supportedFormfactors;
    }
    public void setSupportedFormfactors(String supportedFormfactors) {
        this.supportedFormfactors = supportedFormfactors;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getMaxGpuLength() {
        return maxGpuLength;
    }
    public void setMaxGpuLength(int maxGpuLength) {
        this.maxGpuLength = maxGpuLength;
    }

    public int getExternal5_25Slots() {
        return external5_25Slots;
    }
    public void setExternal5_25Slots(int external5_25Slots) {
        this.external5_25Slots = external5_25Slots;
    }

    public int getExternal3_5Slots() {
        return external3_5Slots;
    }
    public void setExternal3_5Slots(int external3_5Slots) {
        this.external3_5Slots = external3_5Slots;
    }

    public int getInternal3_5Slots() {
        return internal3_5Slots;
    }
    public void setInternal3_5Slots(int internal3_5Slots) {
        this.internal3_5Slots = internal3_5Slots;
    }

    public int getInternal2_5Slots() {
        return internal2_5Slots;
    }
    public void setInternal2_5Slots(int internal2_5Slots) {
        this.internal2_5Slots = internal2_5Slots;
    }

    public int getFrontFans() {
        return frontFans;
    }
    public void setFrontFans(int frontFans) {
        this.frontFans = frontFans;
    }

    public int getRearFans() {
        return rearFans;
    }
    public void setRearFans(int rearFans) {
        this.rearFans = rearFans;
    }

    public int getSideFans() {
        return sideFans;
    }
    public void setSideFans(int sideFans) {
        this.sideFans = sideFans;
    }

    public int getUpperFans() {
        return upperFans;
    }
    public void setUpperFans(int upperFans) {
        this.upperFans = upperFans;
    }

    public int getBottomFans() {
        return bottomFans;
    }
    public void setBottomFans(int bottomFans) {
        this.bottomFans = bottomFans;
    }

    public String getRadiatorLocation() {
        return radiatorLocation;
    }
    public void setRadiatorLocation(String radiatorLocation) {
        this.radiatorLocation = radiatorLocation;
    }

    public String getFrontConnections() {
        return frontConnections;
    }
    public void setFrontConnections(String frontConnections) {
        this.frontConnections = frontConnections;
    }

    public String getExtras() {
        return extras;
    }
    public void setExtras(String extras) {
        this.extras = extras;
    }

    public boolean isGaming() {
        return gaming;
    }
    public void setGaming(boolean gaming) {
        this.gaming = gaming;
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
        specs.add(getSize());
        specs.add(getSupportedFormfactors());
        specs.add(getHeight());
        specs.add(getWidth());
        specs.add(getDepth());
        specs.add(getMaxGpuLength());
        specs.add(getExternal5_25Slots());
        specs.add(getExternal3_5Slots());
        specs.add(getInternal3_5Slots());
        specs.add(getInternal2_5Slots());
        specs.add(getFrontFans());
        specs.add(getRearFans());
        specs.add(getSideFans());
        specs.add(getUpperFans());
        specs.add(getBottomFans());
        specs.add(getRadiatorLocation());
        specs.add(getFrontConnections());
        specs.add(getExtras());
        specs.add(isGaming());
        specs.add(getAverageReview());
        specs.add(getStoreDetails());
        return specs.toArray();
    }
}
