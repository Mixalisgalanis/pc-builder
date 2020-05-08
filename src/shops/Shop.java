package shops;

import java.net.URL;

public class Shop {

    //Class variables
    private String name;
    private URL website;
    private double rating;

    //Constructor
    public Shop(String name, URL link, double rating) {
        this.name = name;
        this.website = link;
        this.rating = rating;
    }

    public Shop(String name) {
        this.name = name;
    }

    //Getters
    public String getName() {
        return name;
    }
    public URL getWebsite() {
        return website;
    }
    public double getRating() {
        return rating;
    }
}
