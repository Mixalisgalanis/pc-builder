package console;

import controller.SkroutzController;
import user.Profile;
import utilities.Reader;

import java.util.ArrayList;

public class ConsoleController {
    //Profiles
    private static ArrayList<Profile> users = new ArrayList<>();

    //Utilities
    private static Reader reader = new Reader();

    //Main Method
    public static void main(String[] args) {
        switch (createMenu("MAIN MENU", new String[]{"Create Profile", "Extract Components", "Exit"})) {
            case "Create Profile":
                createProfile();
                break;
            case "Extract Components":
                extractComponents();
                break;
            case "Exit":
        }
    }


    //Menu Creation Methods
    private static String createMenu(String menuName, String[] options) {
        displayMenu(menuName, options);
        int userAction = reader.readInteger("Action: ");
        while (true) {
            if (userAction > 0 && userAction <= options.length) return options[userAction-1];
            userAction = reader.readInteger("Action Invalid. Please try again: ");
        }
    }

    private static void displayMenu(String menuName, String[] options) {
        System.out.println("\n" + menuName);
        System.out.println("=====================================================");
        int i;
        for (i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("\nPlease select action (1-" + i + ")");
        System.out.println("=====================================================");
    }


    //Essential Methods
    private static void createProfile() {
        String name = reader.readString("Please Enter Your Name: ");
        Double budget = reader.readDouble("Please Enter Your Computer Budget: ");
        Boolean offsetAllowance = reader.readBoolean("Would You Allow an Offset for that budget? ");
        int offset = (!offsetAllowance) ? 0 : reader.readInteger("What Would Be the Maximum Offset? E.g 5 (measured in %): ");
        Boolean gaming = reader.readBoolean("Is This a Gaming Rig?");

        users.add(new Profile(name, budget, offsetAllowance, offset, gaming));
        System.out.println(name + " Profile has Been Created.");
    }

    private static void extractComponents() {
        SkroutzController controller = new SkroutzController();
        controller.extractComponents();
        controller.saveComponents();
    }


}
