package utilities;

public class Math {

    public boolean isInteger(String string){
        try{
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isDouble(String string){
        try{
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isBoolean(String string){
        return string.equals("true") || string.equals("false");

    }
}

