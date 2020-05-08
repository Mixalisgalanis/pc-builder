package utilities;

public class Tokenizer {

    public int extractNumberOfComponents(String string){
        return Integer.parseInt(string.substring(1, string.indexOf(" ")));
    }
}
