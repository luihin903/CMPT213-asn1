import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hin Lui 301571436
 * @version 1.0.0
 */
public class Main {

    public static List<Bike> bikes = new ArrayList<Bike>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        String command = "";
        
        System.out.println("*****************************************");
        System.out.println("* Bike Registry by Hin Lui sn 301571436 *");
        System.out.println("*****************************************");

        while (!command.equals("6")) {
            
            displayMainMenu();
            System.out.print("> ");
            command = input.nextLine();

            switch (command) {
                case "1":
                    displayAllBikes();
                    break;
                case "2":
                    addNewBike();
                    break;
                case "3":
                    deleteBike();
                    break;
                case "4":
                    alterBike();
                    break;
                case "5":
                    debug();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    public static void displayMainMenu() {
        System.out.println("");
        System.out.println("*************");
        System.out.println("* Main Menu *");
        System.out.println("*************");
        System.out.println("1. List bikes");
        System.out.println("2. Add a new Bike");
        System.out.println("3. Remove a Bike");
        System.out.println("4. Change Bike attribute");
        System.out.println("5. DEBUG: Dump objects (toString)");
        System.out.println("6. Exit");
    }

    public static void displayAllBikes() {
        System.out.println("******************");
        System.out.println("* List of Bikes");
        System.out.println("******************");
        System.out.println("ID\tOwner,\tType,\tSerial,\tBrake,\tWheel Size");
        for (Bike b : bikes) {
            System.out.println(b.id + "\t" + b.owner + ",\t" + b.type + ",\t" + b.serial + ",\t" + b.brake + ",\t" + b.size);
        }
    }

    public static void addNewBike() {
        System.out.print("Enter Bike owner name:\t\t\t");
        String owner = input.nextLine();

        System.out.print("Enter Bike type:\t\t\t\t");
        String type = input.nextLine();

        System.out.print("Enter Bike's serial number:\t\t");
        String serial = input.nextLine();

        System.out.print("Enter Bike's brake type:\t\t");
        String brake = input.nextLine();

        boolean pass = false;
        double size = 0;
        while (!pass) {
            System.out.print("Enter Bike's wheel size:\t\t");
            try {
                size = Double.parseDouble(input.nextLine());
                pass = true;
            } catch (Exception e) {
                System.out.println("Invalid size.");
            } 
        }

        bikes.add(new Bike(owner, type, serial, brake, size));

    }

    public static void deleteBike() {
        System.out.println("Delete Bike");
    }

    public static void alterBike() {
        System.out.println("Alter");
    }

    public static void debug() {
        System.out.println("Debug");
    }
}