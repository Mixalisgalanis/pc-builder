package web;

import components.Component;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface Scraper {

    Document connectTo(Document webpage, String url);

    int findItems(String link);

    int findItemsPerPage(String link);

    int findProductPages(String link);

    int findProductPages(int items, String link);

    ArrayList<Component> createComponents(String categoryName, String categorylink, LinkedHashMap<String, String> specNameType);

    Object[] extractSpecs(Document componentWebpage, LinkedHashMap<String, String> specNameType);

    Double extractAverageReview(Document componentWebpage);

    Object[] extractMinimumPrice(Document componentWebpage);

    Object fillMissing(String specType);

}
