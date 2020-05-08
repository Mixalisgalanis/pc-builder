package controller;

import components.*;
import file.FileManager;
import shops.Shop;
import web.SkroutzScraper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class SkroutzController implements Controller {

    //Class variables
    //LinkedHashMap containing <componentName, <component1,component2,...>>
    private LinkedHashMap<String, ArrayList<Component>> componentSpecs;
    //ArrayLists
    private ArrayList<Shop> shops;
    //Utility
    private FileManager fileManager;
    private SkroutzScraper scraper;

    private final static SkroutzComponentInfo componentInfo = new SkroutzComponentInfo();


    //Constructor
    public SkroutzController() {
        componentSpecs = new LinkedHashMap<>();

        shops = new ArrayList<>();
        scraper = new SkroutzScraper();
        fileManager = new FileManager();
    }

    //Component Manipulation Methods
    public void extractComponents() {
        if (fileManager.checkForLocalItems(fileManager.COMPONENT_DIRECTORY))
            loadComponents();
        else
            downloadComponents();
    }
    private void downloadComponents(){
        for (String name : componentInfo.getComponentNames()){
            ArrayList<Component> components = scraper.createComponents(name, componentInfo.findCategoryLink(name), componentInfo.findTemplate(name));
            componentSpecs.put(name, components);
        }
}
    public void saveComponents() {
        if (!fileManager.checkForLocalItems(fileManager.COMPONENT_DIRECTORY)){
            for (String name : componentInfo.getComponentNames()){
                fileManager.createComponentFile(name);
                for (Component component : componentSpecs.get(name)){
                    fileManager.writeComponentFile(component.buildSpecArray());
                }
            }

            fileManager.createOverviewFile();
            fileManager.writeOverviewFile();
            fileManager.closeFiles();
        }
    }
    private void loadComponents() {
        for (String name : componentInfo.getComponentNames()){
            ArrayList<Component> components = fileManager.readComponentFile(name);
            componentSpecs.put(name, components);
        }
        return;
    }
}
