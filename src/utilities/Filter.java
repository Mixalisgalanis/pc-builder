package utilities;

public class Filter {

    //Constants
    private static final String[] MEASUREMENT_UNITS = {"W", "mm", "MB", "MB/s", "IOPS", "DIMM Slots", "Slot", "Port", "€"};

    //Utilities
    private Math math = new Math();

    //Filtering Methods
    public Object analyzeSpec(String specType, String specValue) {
        switch (specType) {
            case "String" :
                return specValue;
            case "Integer":
                return Integer.parseInt(filterNumberSpec(specValue));
            case "Boolean":
                return Boolean.parseBoolean(filterBooleanSpec(specValue));
            default:
                return specValue;
        }
    }

    public Object analyzeSpec(String specValue){
        if (math.isInteger(specValue)) return Integer.parseInt(specValue);
        else if (math.isDouble(specValue)) return Double.parseDouble(specValue);
        else if (math.isBoolean(specValue)) return Boolean.parseBoolean(specValue);
        else return specValue;
    }

    public String filterNumberSpec(String specValue) {
        for (String measurementUnit : MEASUREMENT_UNITS) {
            if (specValue.endsWith(measurementUnit)){
                return filterNumberSpec(specValue.substring(0, specValue.indexOf(measurementUnit)).trim());
            }
        }
        if (math.isInteger(specValue.trim())) return specValue;
        else if (specValue.contains(","))
            return specValue.substring(0, specValue.indexOf(','));
        return "-1";
    }

    public String filterBooleanSpec(String specValue) {
        return (specValue.equals("Ναι")) ? "true" : "false";

    }

}
