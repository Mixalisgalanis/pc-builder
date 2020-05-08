package file;

import components.Component;
import utilities.Filter;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class FileManager {

    //Class variables
    //Constants
    public static final String COMPONENT_FILE_SUFFIX = ".comp";
    public static final String OVERVIEW_FILE_SUFFIX = ".ovv";
    public final String COMPONENT_DIRECTORY = "resources/";
    //Regex Constants
    public final String SPEC_SEPARATOR = " | ";
    public final String SPEC_SEPARATOR_REGEX = "\\s[|]\\s";
    public final String ARRAY_SEPARATOR = " ~ ";
    public final String ARRAY_SEPARATOR_REGEX = "\\s[~]\\s";

    //Files
    private File overviewFile;
    private File componentFile;

    private BufferedWriter bufferedWriterOverview;
    private BufferedWriter bufferedWriterComponent;
    private BufferedReader bufferedReaderOverview;
    private BufferedReader bufferedReaderComponent;


    //Utilities
    private Filter filter = new Filter();


    //File Creation Methods
    public void createOverviewFile(){
        //Define filepath
        overviewFile = new File("Overview" + OVERVIEW_FILE_SUFFIX);
        //Try to create the file
        try{
            bufferedWriterOverview = new BufferedWriter(new FileWriter(overviewFile));
            System.out.println((overviewFile.createNewFile())? "Overview File successfully created." : "Overview File already exists! Updating current file instead!");
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void createComponentFile(String componentName){
        //Define filepath
        componentFile = new File(COMPONENT_DIRECTORY + componentName + COMPONENT_FILE_SUFFIX);
        //Try to create the file
        try{
            if (componentFile.createNewFile()) System.out.println("File " + componentName + ".cmp successfully created.");
            else System.out.println("File " + componentName + " .cmp already exists!");
            bufferedWriterComponent = new BufferedWriter(new FileWriter(componentFile));
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    //File Closure Method
    public void closeFiles(){
        try {
            if (bufferedWriterOverview != null) bufferedWriterOverview.close();
            if (bufferedWriterComponent != null) bufferedWriterComponent.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //File Writing Methods
    public void writeOverviewFile(){
        File filepath = new File(COMPONENT_DIRECTORY);
        if (!filepath.exists() || !filepath.isDirectory()) {
            System.err.println("Directory not found!");
        }
        LinkedHashMap<String, Integer> numberOfComponents = new LinkedHashMap<>();
        //Getting number of Components
        for (File file : Objects.requireNonNull(filepath.listFiles())){
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                int numberOfItems = 0;
                while((bufferedReader.readLine()) != null) {
                    numberOfItems++;
                }
                numberOfComponents.put(file.getName().substring(0,file.getName().indexOf('.')), numberOfItems);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Map.Entry<String, Integer> entry : numberOfComponents.entrySet()){
            try {
                bufferedWriterOverview.write(entry.getKey() + " | " + entry.getValue() + " items");
                bufferedWriterOverview.newLine();
                bufferedWriterOverview.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Overview file write successful!");
    }

    public void writeComponentFile(Object[] specs){
        try {
            bufferedWriterComponent.write(specsToString(specs));
            bufferedWriterComponent.newLine();
            bufferedWriterComponent.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //File Reading Methods
    public void readOverviewFile(){

    }

    public ArrayList<Component> readComponentFile(String componentName){
        ArrayList<Component> components = new ArrayList<>();
        try{
            File file = new File(COMPONENT_DIRECTORY + componentName + COMPONENT_FILE_SUFFIX);
            if (!file.exists()) System.err.println("Such File does not exist!");
            bufferedReaderComponent = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReaderComponent.readLine()) != null){
                Class<?> c = Class.forName("components." + componentName);
                Constructor<?> constructor = c.getConstructor(Object[].class);
                Object obj = constructor.newInstance(new Object[] {stringToSpecs(line)});
                components.add((Component) obj);
            }
        } catch (ClassNotFoundException | IOException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
        }
        return components;
    }

    //Conversion Method
    private String specsToString(Object[] specs){
        StringBuilder result = new StringBuilder();
        for (Object object : specs){
            String name = object.getClass().getSimpleName();
            if (object.getClass().getSimpleName().equals("Object[]")){
                for (Object insideObject : (Object[]) object){
                    result.append(insideObject.toString());
                    result.append(ARRAY_SEPARATOR);
                }
            } else result.append(object.toString());
            result.append(SPEC_SEPARATOR);
        }
        return result.toString();
    }

    private Object[] stringToSpecs(String line){
        ArrayList<Object> specs = new ArrayList<>();
        //Whole line of text
        String[] stringSpecs = line.split(SPEC_SEPARATOR_REGEX);
        for (String stringSpec : stringSpecs){ // | spec |
            // | sub_spec[0] ~ sub_spec[1] ... |
            if (stringSpec.contains(ARRAY_SEPARATOR)){
                String[] stringArraySpecs = stringSpec.split(ARRAY_SEPARATOR_REGEX);
                ArrayList<Object> arraySpecs = new ArrayList<>();
                for (String specValue : stringArraySpecs){
                    arraySpecs.add(filter.analyzeSpec(specValue));
                }
                specs.add(arraySpecs.toArray());
            }
            else specs.add(filter.analyzeSpec(stringSpec));
        }
        return specs.toArray();
    }

    //File Checking Method
    public Boolean checkForLocalItems(String directory){
        File filepath = new File(directory);
        return (filepath.exists() && filepath.isDirectory() && (filepath.listFiles() != null) && (filepath.listFiles().length!=0));
    }



}
