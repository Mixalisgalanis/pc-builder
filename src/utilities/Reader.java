package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Reader {

    private BufferedReader in;

    //Constructor
    public Reader() {
        super();
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    //Reading Methods
    public String readString(String message) {
        System.out.print(message);
        try {
            String str = in.readLine();
            return (str.isEmpty()) ? readString(message) : str;
        } catch (IOException e) {
            return readString(message);
        }
    }

    public int readInteger(String message) {
        System.out.print(message);
        try {
            return Integer.parseInt(in.readLine());
        } catch (IOException | NumberFormatException e) {
            return readInteger(message);
        }
    }

    public double readDouble(String message) {
        try {
            System.out.print(message);
            return Double.parseDouble(in.readLine());
        } catch (IOException | NumberFormatException e) {
            return readDouble(message);
        }
    }

    public Boolean readBoolean(String message) {
        System.out.println(message);
        try {
            String str = in.readLine();
            if (str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("y")) str = "true";
            else if (str.equalsIgnoreCase("no") || str.equalsIgnoreCase("n")) str = "false";
            return Boolean.parseBoolean(str);
        } catch (IOException e) {
            return readBoolean(message);
        }
    }

    public Date readDate(String message) {
        System.out.print(message);
        try {
            String str = in.readLine();
            Locale l = new Locale("el", "GR");
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, l);
            return df.parse(str);
        } catch (IOException | ParseException e) {
            return null;
        }
    }

    public Date readTime(String message) {
        System.out.print(message);
        try {
            String str = in.readLine();
            DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT);
            return df.parse(str);
        } catch (IOException | ParseException e) {
            return null;
        }
    }
}
