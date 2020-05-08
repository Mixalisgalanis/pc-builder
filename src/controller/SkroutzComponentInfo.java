package controller;

import java.util.LinkedHashMap;

public final class SkroutzComponentInfo {

    //Component Names
    private static final String MB_NAME = "Motherboard";
    private static final String CPU_NAME = "Processor";
    private static final String CASE_NAME = "Case";
    private static final String GPU_NAME = "GraphicsCard";
    private static final String HDD_NAME = "HardDrive";
    private static final String PSU_NAME = "PowerSupply";
    private static final String RAM_NAME = "Ram";
    private static final String SSD_NAME = "SolidStateDrive";

    private static final String[] COMPONENT_NAMES = {MB_NAME, CPU_NAME, CASE_NAME, GPU_NAME, HDD_NAME, PSU_NAME, RAM_NAME, SSD_NAME};

    //LinkedHashMap containing <componentName,componentLink>
    private static LinkedHashMap<String, String> componentCategoryLinks;
    //LinkedHashMap containing <componentName, <specName, specType>>
    private static LinkedHashMap<String, LinkedHashMap<String, String>> componentsTemplate;


    public  SkroutzComponentInfo() {
        componentCategoryLinks = new LinkedHashMap<>();
        initializeComponentCategoryLinks();
        initializeSpecTypes();
    }

    //Initialization
    private void initializeComponentCategoryLinks() {
        componentCategoryLinks.put(MB_NAME, "https://www.skroutz.gr/c/31/motherboards-mhtrikes.html");
        componentCategoryLinks.put(CPU_NAME, "https://www.skroutz.gr/c/32/cpu-epeksergastes.html");
        componentCategoryLinks.put(CASE_NAME, "https://www.skroutz.gr/c/28/cases-koutia.html");
        componentCategoryLinks.put(GPU_NAME, "https://www.skroutz.gr/c/55/kartes-grafikwn-vga.html");
        componentCategoryLinks.put(HDD_NAME, "https://www.skroutz.gr/c/1715/hdd_sklhroi_diskoi.html");
        componentCategoryLinks.put(PSU_NAME, "https://www.skroutz.gr/c/30/psu-trofodotika.html");
        componentCategoryLinks.put(RAM_NAME, "https://www.skroutz.gr/c/56/mnhmes-pc-ram.html");
        componentCategoryLinks.put(SSD_NAME, "https://www.skroutz.gr/c/88/ssd-sklhroi-diskoi.html");
    }
    private void initializeSpecTypes() {
        componentsTemplate = new LinkedHashMap<>();
        //Motherboard
        LinkedHashMap<String, String> motherboardSpecNameTypes = new LinkedHashMap<>();
        motherboardSpecNameTypes.put("Γενικά, Μέγεθος", "String");
        motherboardSpecNameTypes.put("Γενικά, Τύπος", "String");
        motherboardSpecNameTypes.put("Επεξεργαστής, Υποστηριζόμενοι Επεξεργαστές", "String");
        motherboardSpecNameTypes.put("Επεξεργαστής, Μοντέλα", "String");
        motherboardSpecNameTypes.put("Επεξεργαστής, Υποστηριζόμενη Γενιά", "String");
        motherboardSpecNameTypes.put("Επεξεργαστής, Socket", "String");
        motherboardSpecNameTypes.put("Chipset, Μοντέλο", "String");
        motherboardSpecNameTypes.put("Μνήμη, Τύπος", "String");
        motherboardSpecNameTypes.put("Μνήμη, Πλήθος", "Integer");
        motherboardSpecNameTypes.put("Μνήμη, Ταχύτητες Μνήμης", "String");
        motherboardSpecNameTypes.put("Μνήμη, Λειτουργία Μνήμης", "String");
        motherboardSpecNameTypes.put("Εσωτερικές Συνδέσεις, PCI Express x16 2.0", "Integer");
        motherboardSpecNameTypes.put("Εσωτερικές Συνδέσεις, PCI Express x16 3.0", "Integer");
        motherboardSpecNameTypes.put("Εσωτερικές Συνδέσεις, Πλήθος SATA II 3Gb/s", "Integer");
        motherboardSpecNameTypes.put("Εσωτερικές Συνδέσεις, Πλήθος SATA III 6Gb/s", "Integer");
        motherboardSpecNameTypes.put("Εσωτερικές Συνδέσεις, Λοιπές Εσωτερικές Συνδέσεις", "String");
        motherboardSpecNameTypes.put("Εξωτερικές Συνδέσεις, Πίσω Έξοδοι USB 2.0", "Integer");
        motherboardSpecNameTypes.put("Εξωτερικές Συνδέσεις, Πίσω Έξοδοι USB 3.0", "Integer");
        motherboardSpecNameTypes.put("Εξωτερικές Συνδέσεις, Πίσω Έξοδοι USB 3.1", "Integer");
        motherboardSpecNameTypes.put("Εξωτερικές Συνδέσεις, Τύπος USB", "String");
        motherboardSpecNameTypes.put("Εξωτερικές Συνδέσεις, Ethernet (LAN)", "Integer");
        motherboardSpecNameTypes.put("Εξωτερικές Συνδέσεις, Λοιπές Εξωτερικές Συνδέσεις", "String");
        motherboardSpecNameTypes.put("Δυνατότητες, Parallel Processing Technology", "String");
        motherboardSpecNameTypes.put("Δυνατότητες, Κανάλια Κάρτας Ήχου", "String");
        motherboardSpecNameTypes.put("Δυνατότητες, Onboard Κάρτα Γραφικών", "Boolean");
        motherboardSpecNameTypes.put("Δυνατότητες, Extra", "String");
        //CPU
        LinkedHashMap<String, String> cpuSpecNameTypes = new LinkedHashMap<>();
        cpuSpecNameTypes.put("Γενικά, Οικογένεια", "String");
        cpuSpecNameTypes.put("Γενικά, Πυρήνες", "Integer");
        cpuSpecNameTypes.put("Γενικά, Threads", "Integer");
        cpuSpecNameTypes.put("Γενικά, Συχνότητα Επεξεργαστή", "Integer");
        cpuSpecNameTypes.put("Γενικά, Μικροαρχιτεκτονική", "String");
        cpuSpecNameTypes.put("Γενικά, Socket", "String");
        cpuSpecNameTypes.put("Γενικά, 64-bit", "Boolean");
        cpuSpecNameTypes.put("Γενικά, Thermal Design Power (TDP)", "Integer");
        cpuSpecNameTypes.put("Γενικά, Ενσωματωμένη Κάρτα γραφικών", "String");
        cpuSpecNameTypes.put("Γενικά, Συσκευασία", "String");
        //Case
        LinkedHashMap<String, String> caseSpecNameTypes = new LinkedHashMap<>();
        caseSpecNameTypes.put("Διαστάσεις, Μέγεθος", "String");
        caseSpecNameTypes.put("Διαστάσεις, Τύπος", "String");
        caseSpecNameTypes.put("Διαστάσεις, Ύψος", "Integer");
        caseSpecNameTypes.put("Διαστάσεις, Πλάτος", "Integer");
        caseSpecNameTypes.put("Διαστάσεις, Βάθος", "Integer");
        caseSpecNameTypes.put("Διαστάσεις, Μέγιστο Μήκος Κάρτας Γραφικών", "Integer");
        caseSpecNameTypes.put("Θέσεις Συσκευών, Eξωτερικές Θύρες 5.25\"", "Integer");
        caseSpecNameTypes.put("Θέσεις Συσκευών, Eξωτερικές Θύρες 3.5\"", "Integer");
        caseSpecNameTypes.put("Θέσεις Συσκευών, Εσωτερικές Θύρες 3.5\"", "Integer");
        caseSpecNameTypes.put("Θέσεις Συσκευών, Εσωτερικές Θύρες 2.5\"", "Integer");
        caseSpecNameTypes.put("Θέσεις Ανεμιστήρων, Μπροστινές Θέσεις", "Integer");
        caseSpecNameTypes.put("Θέσεις Ανεμιστήρων, Πίσω Θέσεις", "Integer");
        caseSpecNameTypes.put("Θέσεις Ανεμιστήρων, Πλαινές Θέσεις", "Integer");
        caseSpecNameTypes.put("Θέσεις Ανεμιστήρων, Άνω Θέσεις", "Integer");
        caseSpecNameTypes.put("Θέσεις Ανεμιστήρων, Κάτω Θέσεις", "Integer");
        caseSpecNameTypes.put("Υποστήριξη Υδρόψυξης, Θέση Ψυγείου", "String");
        caseSpecNameTypes.put("Δυνατότητες, Συνδεσιμότητα", "String");
        caseSpecNameTypes.put("Δυνατότητες, Πρόσθετα", "String");
        caseSpecNameTypes.put("Δυνατότητες, Gaming", "Boolean");
        //Gpu
        LinkedHashMap<String, String> gpuSpecNameTypes = new LinkedHashMap<>();
        gpuSpecNameTypes.put("Βασικά Χαρακτηριστικά, Κατασκευαστής Επεξεργαστή", "String");
        gpuSpecNameTypes.put("Βασικά Χαρακτηριστικά, Chipset Model", "String");
        gpuSpecNameTypes.put("Βασικά Χαρακτηριστικά, Interface", "String");
        gpuSpecNameTypes.put("Βασικά Χαρακτηριστικά, Χωρητικότητα Μνήμης", "Integer");
        gpuSpecNameTypes.put("Βασικά Χαρακτηριστικά, Τύπος Μνήμης", "String");
        gpuSpecNameTypes.put("Βασικά Χαρακτηριστικά, Τεχνολογία Παράλληλης Επεξεργασίας", "String");
        gpuSpecNameTypes.put("Βασικά Χαρακτηριστικά, Ειδικά Χαρακτηριστικά", "String");
        gpuSpecNameTypes.put("Τεχνικά Χαρακτηριστικά, Ταχύτητα Επεξεργαστή (Base Clock)", "Integer");
        gpuSpecNameTypes.put("Τεχνικά Χαρακτηριστικά, Ταχύτητα Μνήμης", "Integer");
        gpuSpecNameTypes.put("Τεχνικά Χαρακτηριστικά, Μέγιστη Ανάλυση", "String");
        gpuSpecNameTypes.put("Τεχνικά Χαρακτηριστικά, Memory bus", "String");
        gpuSpecNameTypes.put("Τεχνικά Χαρακτηριστικά, Ελάχιστη Ισχύς Τροφοδοτικού", "Integer");
        gpuSpecNameTypes.put("Συνδεσιμότητα, Συνδεσιμότητα", "String");
        gpuSpecNameTypes.put("Συνδεσιμότητα, Dual Link DVI", "Boolean");
        //hdd
        LinkedHashMap<String, String> hddSpecNameTypes = new LinkedHashMap<>();
        hddSpecNameTypes.put("Συμβατότητα, Χρήση", "String");
        hddSpecNameTypes.put("Γενικά, Χωρητικότητα", "Integer");
        hddSpecNameTypes.put("Γενικά, Πρωτόκολλο Επικοινωνίας", "String");
        hddSpecNameTypes.put("Γενικά, Hybrid", "Boolean");
        hddSpecNameTypes.put("Επιδόσεις, Ταχύτητα Περιστροφής", "Integer");
        hddSpecNameTypes.put("Επιδόσεις, Μέγεθος Cache", "Integer");
        hddSpecNameTypes.put("Διαστάσεις, Form Factor", "String");
        //psu
        LinkedHashMap<String, String> psuSpecNameTypes = new LinkedHashMap<>();
        psuSpecNameTypes.put("Γενικά, Ισχύς", "Integer");
        psuSpecNameTypes.put("Γενικά, Τύπος PFC", "String");
        psuSpecNameTypes.put("Γενικά, Τύπος", "String");
        psuSpecNameTypes.put("Γενικά, Modular", "String");
        psuSpecNameTypes.put("Γενικά, Certification", "String");
        psuSpecNameTypes.put("Γενικά, Διάσταση Ανεμιστήρα", "Integer");
        psuSpecNameTypes.put("Γενικά, Προστασία Ισχύος", "String");
        psuSpecNameTypes.put("Γενικά, Extra", "String");
        //ram
        LinkedHashMap<String, String> ramSpecNameTypes = new LinkedHashMap<>();
        ramSpecNameTypes.put("Βασικά Χαρακτηριστικά, Χωρητικότητα", "Integer");
        ramSpecNameTypes.put("Βασικά Χαρακτηριστικά, Τύπος", "String");
        ramSpecNameTypes.put("Βασικά Χαρακτηριστικά, Συχνότητα", "Integer");
        ramSpecNameTypes.put("Βασικά Χαρακτηριστικά, Τύπος υπολογιστή", "String");
        ramSpecNameTypes.put("Ειδικά Χαρακτηριστικά, Πλήθος modules", "Integer");
        ramSpecNameTypes.put("Ειδικά Χαρακτηριστικά, CAS Latency", "Integer");
        //ssd
        LinkedHashMap<String, String> ssdSpecNameTypes = new LinkedHashMap<>();
        ssdSpecNameTypes.put("Γενικά, Χωρητικότητα", "Integer");
        ssdSpecNameTypes.put("Γενικά, Πρωτόκολλο Επικοινωνίας", "String");
        ssdSpecNameTypes.put("Επιδόσεις, Read Speed", "Integer");
        ssdSpecNameTypes.put("Επιδόσεις, Write Speed", "Integer");
        ssdSpecNameTypes.put("Επιδόσεις, Maximum 4KB Random Write", "Integer");
        ssdSpecNameTypes.put("Διαστάσεις, Form Factor", "String");

        componentsTemplate.put(MB_NAME, motherboardSpecNameTypes);
        componentsTemplate.put(CPU_NAME, cpuSpecNameTypes);
        componentsTemplate.put(CASE_NAME, caseSpecNameTypes);
        componentsTemplate.put(GPU_NAME, gpuSpecNameTypes);
        componentsTemplate.put(HDD_NAME, hddSpecNameTypes);
        componentsTemplate.put(PSU_NAME, psuSpecNameTypes);
        componentsTemplate.put(RAM_NAME, ramSpecNameTypes);
        componentsTemplate.put(SSD_NAME, ssdSpecNameTypes);

    }


    //Setters and Getters
    public LinkedHashMap<String, String> getComponentCategoryLinks() {
        return componentCategoryLinks;
    }
    public void setComponentCategoryLinks(LinkedHashMap<String, String> componentCategoryLinks) {
        SkroutzComponentInfo.componentCategoryLinks = componentCategoryLinks;
    }

    public LinkedHashMap<String, LinkedHashMap<String, String>> getComponentsTemplate() {
        return componentsTemplate;
    }
    public void setComponentsTemplate(LinkedHashMap<String, LinkedHashMap<String, String>> componentsTemplate) {
        SkroutzComponentInfo.componentsTemplate = componentsTemplate;
    }

    public String[] getComponentNames() {
        return COMPONENT_NAMES;
    }

    //Search Methods
    public String findCategoryLink(String componentName){
        return componentCategoryLinks.get(componentName);
    }

    public LinkedHashMap<String, String> findTemplate(String componentName){
        return componentsTemplate.get(componentName);
    }


}
