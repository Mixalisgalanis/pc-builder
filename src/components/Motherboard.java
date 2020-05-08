package components;

import java.util.ArrayList;

public class Motherboard extends Component {

    //Class variables
    //MotherboardGeneralInfo
    private String formfactor;
    private String useType;
    //MotherboardCpuInfo
    private String supportedCpuManufacturer;
    private String supportedCpuModels;
    private String supportedGenerations;
    private String socket;
    //MotherboardChipsetInfo
    private String chipsetModel;
    //MotherboardMemoryInfo
    private String memoryType;
    private int slots;
    private String supportedClockSpeeds;
    private String channelType;
    //MotherboardInternalConnectionsInfo
    private int pciExpress2Slots;
    private int pciExpress3Slots;
    private int sata3GpbsPorts;
    private int sata6GbpsPorts;
    private String otherInternalConnections;
    //MotherboardExternalConnectionsInfo
    private int rearUSB2_0Ports;
    private int rearUSB3_0Ports;
    private int rearUSB3_1Ports;
    private String usbTypes;
    private int ethernetPorts;
    private String otherExternalConnections;
    //MotherboardCapabilitiesInfo
    private String parallelProcessingTechnology;
    private String soundCardChannels;
    private boolean onboardGraphicsCard;
    private String extras;

    //Constructors
    public Motherboard(Object[] specs){
        super((String)specs[0]);
        super.setComponentLink((String) specs[1]);
        int counter = 2;
        this.formfactor = (String) specs[counter++];
        this.useType = (String)specs[counter++];
        this.supportedCpuManufacturer = (String)specs[counter++];
        this.supportedCpuModels = (String)specs[counter++];
        this.supportedGenerations = (String) specs[counter++];
        this.socket = (String)specs[counter++];
        this.chipsetModel = (String)specs[counter++];
        this.memoryType = (String)specs[counter++];
        this.slots = (int)specs[counter++];
        this.supportedClockSpeeds = (String)specs[counter++];
        this.channelType = (String)specs[counter++];
        this.pciExpress2Slots = (int)specs[counter++];
        this.pciExpress3Slots = (int)specs[counter++];
        this.sata3GpbsPorts = (int)specs[counter++];
        this.sata6GbpsPorts = (int)specs[counter++];
        this.otherInternalConnections = (String)specs[counter++];
        this.rearUSB2_0Ports = (int)specs[counter++];
        this.rearUSB3_0Ports = (int)specs[counter++];
        this.rearUSB3_1Ports = (int)specs[counter++];
        this.usbTypes = (String)specs[counter++];
        this.ethernetPorts = (int)specs[counter++];
        this.otherExternalConnections = (String)specs[counter++];
        this.parallelProcessingTechnology = (String)specs[counter++];
        this.soundCardChannels = (String) specs[counter++];
        this.onboardGraphicsCard = (boolean) specs[counter++];
        this.extras = (String) specs[counter++];
        super.setAverageReview((Double) specs[counter++]);
        setStoreDetails((Object[]) specs[counter]);
    }

    //Setters and Getters

    public String getFormfactor() {
        return formfactor;
    }
    public void setFormfactor(String formfactor) {
        this.formfactor = formfactor;
    }

    public String getUseType() {
        return useType;
    }
    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getSupportedCpuManufacturer() {
        return supportedCpuManufacturer;
    }
    public void setSupportedCpuManufacturer(String supportedCpuManufacturer) {
        this.supportedCpuManufacturer = supportedCpuManufacturer;
    }

    public String getSupportedCpuModels() {
        return supportedCpuModels;
    }
    public void setSupportedCpuModels(String supportedCpuModels) {
        this.supportedCpuModels = supportedCpuModels;
    }

    public String getSupportedGenerations() {
        return supportedGenerations;
    }
    public void setSupportedGenerations(String supportedGenerations) {
        this.supportedGenerations = supportedGenerations;
    }

    public String getSocket() {
        return socket;
    }
    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getChipsetModel() {
        return chipsetModel;
    }
    public void setChipsetModel(String chipsetModel) {
        this.chipsetModel = chipsetModel;
    }

    public String getMemoryType() {
        return memoryType;
    }
    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public int getSlots() {
        return slots;
    }
    public void setSlots(int slots) {
        this.slots = slots;
    }

    public String getSupportedClockSpeeds() {
        return supportedClockSpeeds;
    }
    public void setSupportedClockSpeeds(String supportedClockSpeeds) {
        this.supportedClockSpeeds = supportedClockSpeeds;
    }

    public String getChannelType() {
        return channelType;
    }
    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public int getPciExpress2Slots() {
        return pciExpress2Slots;
    }
    public void setPciExpress2Slots(int pciExpress2Slots) {
        this.pciExpress2Slots = pciExpress2Slots;
    }

    public int getPciExpress3Slots() {
        return pciExpress3Slots;
    }
    public void setPciExpress3Slots(int pciExpress3Slots) {
        this.pciExpress3Slots = pciExpress3Slots;
    }

    public int getSata3GpbsPorts() {
        return sata3GpbsPorts;
    }
    public void setSata3GpbsPorts(int sata3GpbsPorts) {
        this.sata3GpbsPorts = sata3GpbsPorts;
    }

    public int getSata6GbpsPorts() {
        return sata6GbpsPorts;
    }
    public void setSata6GbpsPorts(int sata6GbpsPorts) {
        this.sata6GbpsPorts = sata6GbpsPorts;
    }

    public String getOtherInternalConnections() {
        return otherInternalConnections;
    }
    public void setOtherInternalConnections(String otherInternalConnections) {
        this.otherInternalConnections = otherInternalConnections;
    }

    public int getRearUSB2_0Ports() {
        return rearUSB2_0Ports;
    }
    public void setRearUSB2_0Ports(int rearUSB2_0Ports) {
        this.rearUSB2_0Ports = rearUSB2_0Ports;
    }

    public int getRearUSB3_0Ports() {
        return rearUSB3_0Ports;
    }
    public void setRearUSB3_0Ports(int rearUSB3_0Ports) {
        this.rearUSB3_0Ports = rearUSB3_0Ports;
    }

    public int getRearUSB3_1Ports() {
        return rearUSB3_1Ports;
    }
    public void setRearUSB3_1Ports(int rearUSB3_1Ports) {
        this.rearUSB3_1Ports = rearUSB3_1Ports;
    }

    public String getUsbTypes() {
        return usbTypes;
    }
    public void setUsbTypes(String usbTypes) {
        this.usbTypes = usbTypes;
    }

    public int getEthernetPorts() {
        return ethernetPorts;
    }
    public void setEthernetPorts(int ethernetPorts) {
        this.ethernetPorts = ethernetPorts;
    }

    public String getOtherExternalConnections() {
        return otherExternalConnections;
    }
    public void setOtherExternalConnections(String otherExternalConnections) {
        this.otherExternalConnections = otherExternalConnections;
    }

    public String getParallelProcessingTechnology() {
        return parallelProcessingTechnology;
    }
    public void setParallelProcessingTechnology(String parallelProcessingTechnology) {
        this.parallelProcessingTechnology = parallelProcessingTechnology;
    }

    public String getSoundCardChannels() {
        return soundCardChannels;
    }
    public void setSoundCardChannels(String soundCardChannels) {
        this.soundCardChannels = soundCardChannels;
    }

    public boolean isOnboardGraphicsCard() {
        return onboardGraphicsCard;
    }
    public void setOnboardGraphicsCard(boolean onboardGraphicsCard) {
        this.onboardGraphicsCard = onboardGraphicsCard;
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
        specs.add(getFormfactor());
        specs.add(getUseType());
        specs.add(getSupportedCpuManufacturer());
        specs.add(getSupportedCpuModels());
        specs.add(getSupportedGenerations());
        specs.add(getSocket());
        specs.add(getChipsetModel());
        specs.add(getMemoryType());
        specs.add(getSlots());
        specs.add(getSupportedClockSpeeds());
        specs.add(getChannelType());
        specs.add(getPciExpress2Slots());
        specs.add(getPciExpress3Slots());
        specs.add(getSata3GpbsPorts());
        specs.add(getSata6GbpsPorts());
        specs.add(getOtherInternalConnections());
        specs.add(getRearUSB2_0Ports());
        specs.add(getRearUSB3_0Ports());
        specs.add(getRearUSB3_1Ports());
        specs.add(getUsbTypes());
        specs.add(getEthernetPorts());
        specs.add(getOtherExternalConnections());
        specs.add(getParallelProcessingTechnology());
        specs.add(getSoundCardChannels());
        specs.add(isOnboardGraphicsCard());
        specs.add(getExtras());
        specs.add(getAverageReview());
        specs.add(getStoreDetails());
        return specs.toArray();
    }
}
