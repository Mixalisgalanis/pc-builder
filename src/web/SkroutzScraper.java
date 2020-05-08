package web;

import components.Component;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import utilities.Filter;
import utilities.Math;
import utilities.Tokenizer;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SkroutzScraper implements Scraper {

    //Class Variables
    //Constants
    private static final String SKROUTZ_PREFIX = "https://www.skroutz.gr/";
    private static final String COMPONENT_PREFIX = "s/";
    private static final String SPECIFIC_PAGE_PREFIX = "?page=";

    //Components Webpages
    private Document categoryWebpage;
    //Utilities
    private Tokenizer tokenizer;
    private Filter filter;

    //Constructor
    public SkroutzScraper() {
        tokenizer = new Tokenizer();
        filter = new Filter();
    }

    //Web Utility Methods
    public Document connectTo(Document webpage, String url) {
        try {
            webpage = Jsoup.connect(url).userAgent("Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.4 Safari/537.36").get();
        } catch (IOException ex) {
            System.err.println("Website not found.");
        }
        return webpage;
    }

    public int findItems(String link) {
        categoryWebpage = connectTo(categoryWebpage, link);
        //Figures out the number of pages based on number of products in a category
        String itemsText = categoryWebpage.select("h1.page-title").select("span").text();
        return tokenizer.extractNumberOfComponents(itemsText);
    }

    public int findItemsPerPage(String link){
        //Assuming already connected to webpage
        int counter = 0;
        for (Element row : categoryWebpage.select("li.cf.card")){
            counter++;
        }
        return counter;
    }

    public int findProductPages(String link) {
        return findItems(link) / findItemsPerPage(link);
    }

    public int findProductPages(int items, String link) {
        return items / findItemsPerPage(link);
    }

    //Essential methods
    public ArrayList<Component> createComponents(String categoryName, String categorylink, LinkedHashMap<String, String> specNameType){
        ArrayList<Component> components = new ArrayList<>();

        int items = findItems(categorylink);
        int pages = findProductPages(items, categorylink);
        //For each page of items (18 (or 30) items per page)
        double linksAcquired = 0;
        for (int i = 0; i < 1; i++) {
            ArrayList<Document> componentWebpages = new ArrayList<>();
            //Connects to next page
            categoryWebpage = connectTo(categoryWebpage, categorylink + SPECIFIC_PAGE_PREFIX + (i + 1));
            //For each product in a category
            for (Element row : categoryWebpage.select("li.cf.card")) {
                String percentage = String.format("%.2f", ((++linksAcquired)/items) * 100);
                System.out.println("Extracting " + categoryName + " " + (int)linksAcquired + "/" + items  + ", page " + i + "/" + pages + ": (" + percentage + "% Done)");
                //Save HTML files of all items of page i
                final String componentLink = SKROUTZ_PREFIX + COMPONENT_PREFIX + (row.select("a").last().attr("href")).substring(3);
                componentWebpages.add(connectTo(new Document(""), componentLink));

            }
            for (Document componentWebpage : componentWebpages){
                try {
                    Class<?> c = Class.forName("components." + categoryName);
                    Constructor<?> constructor = c.getConstructor(Object[].class);
                    Object obj = constructor.newInstance(new Object[] {extractSpecs(componentWebpage, specNameType)});
                    components.add((Component) obj);
                } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            componentWebpages.clear();
        }
        return components;
    }

    public Object[] extractSpecs(Document componentWebpage, LinkedHashMap<String, String> specNameType){
            //Builds a list of realSpecs
            ArrayList<Object> realSpecs = new ArrayList<>();
            HashMap<String, String> realSpecNameType = new LinkedHashMap<>();

            //Extracting name and link
            final String name = componentWebpage.select("h1.page-title").text();
            final String componentLink = componentWebpage.location();
            realSpecs.add(name);
            realSpecs.add(componentLink);

            for (Element insideRow : componentWebpage.select("div.spec-groups").select("dl")) {
                String specName = insideRow.select("dt").text();
                String specValue = insideRow.select("dd").text();

                realSpecNameType.put(specName, specValue);
            }

            for (String key : specNameType.keySet()) {
                //SpecValueName not missing from realSpecNameType Map
                String realKey = key.substring(key.indexOf(',') + 2, key.length());
                if (realSpecNameType.containsKey(realKey)) {
                    realSpecs.add(filter.analyzeSpec(specNameType.get(key), realSpecNameType.get(realKey)));
                } else { //Missing
                    realSpecs.add(fillMissing(specNameType.get(key)));
                }
            }
            realSpecs.add(extractAverageReview(componentWebpage));
            realSpecs.add(extractMinimumPrice(componentWebpage));

        return realSpecs.toArray();
    }

    public Double extractAverageReview(Document componentWebpage){
        String scoreRow = componentWebpage.select("div.rating-average.cf").last().text();
        String score =  (scoreRow.contains(",")) ? scoreRow.substring(0, scoreRow.indexOf(' ')).replace(',', '.') : scoreRow.substring(1,2);
        return (!score.equals("")) ? Double.parseDouble(score) : -1;
    }

    public Object[] extractMinimumPrice(Document componentWebpage){
        ArrayList<Object> storeDetails = new ArrayList<>();

        Element firstStoreCard = componentWebpage.selectFirst("li.card.js-product-card");
        String storeName = firstStoreCard
                .select("div.shop-details.js-shop-details.js-product-uservoice")
                .select("a.shop.icon.js-shop-info-link")
                .text();
        String storeProductLink = SKROUTZ_PREFIX + firstStoreCard
                .select("div.item.js-product")
                .select("a").last()
                .attr("href")
                .substring(1);
        String availability =  firstStoreCard
                .selectFirst("p.availability")
                .select("span.availability")
                .text();

        String initialPrice = firstStoreCard
                .select("div.price")
                .select("div.js-blp")
                .text();
        /*String deliveryFee = firstStoreCard
                .select("div.price")
                .select("div.js-blp")
                .select("span.extra-cost.cf").first()
                .select("em")
                .text();
        String cashFee = firstStoreCard
                .select("div.price")
                .select("div.js-blp")
                .select("span.extra-cost.cf").last()
                .select("em")
                .text();*/

        storeDetails.add(storeName);
        storeDetails.add(storeProductLink);
        storeDetails.add(availability);
        storeDetails.add(Double.parseDouble(filter.filterNumberSpec(initialPrice)));
        /*storeDetails.add(Double.parseDouble(filterNumberSpec(deliveryFee)));
        storeDetails.add(Double.parseDouble(filterNumberSpec(cashFee)));*/

        return storeDetails.toArray();
    }

    // Value Analyzing methods
    public Object fillMissing(String specType) {
        switch (specType) {
            case "String" :
                return "";
            case "Integer":
                return -1;
            case "Boolean":
                return false;
            default:
                return "";
        }
    }
}
