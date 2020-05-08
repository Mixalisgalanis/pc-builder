package test;


import controller.SkroutzController;
import utilities.Filter;
import web.SkroutzScraper;

public class Tester {

    public static void main(String[] args) {

        Filter filter = new Filter();

        Object object = filter.analyzeSpec("AMD");
        System.out.println("Done");
    }
}
