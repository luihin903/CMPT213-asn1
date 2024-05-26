import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class contains the main method.
 * @author Hin Lui 301571436
 * @version 1.0.0
 */
public class Main {

    private static List<Bike> bikes = new ArrayList<Bike>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String command = "";
        
        System.out.println("*****************************************");
        System.out.println("* Bike Registry by Hin Lui sn 301571436 *");
        System.out.println("*****************************************");

        while (!command.equals("6")) {
            try {
                    
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
        
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("BYE!");
    }

    private static void displayMainMenu() {
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

    // 1
    private static void displayAllBikes() {
        System.out.println("******************");
        System.out.println("* List of Bikes: *");
        System.out.println("******************");
        
        int lengths[] = {5, 4, 6, 5};
        for (Bike b : bikes) {
            lengths[0] = max(lengths[0], b.getOwner().length());
            lengths[1] = max(lengths[1], b.getType().length());
            lengths[2] = max(lengths[2], b.getSerial().length());
            lengths[3] = max(lengths[3], b.getBrake().toString().length());
        }

        for (int i = 0; i < lengths.length; i ++) {
            lengths[i] += 3;
        }

        System.out.println(String.format(
            "ID  " +
            "%-" + lengths[0] + "s" +
            "%-" + lengths[1] + "s" +
            "%-" + lengths[2] + "s" +
            "%-" + lengths[3] + "s" +
            "Wheel Size",
            "Owner,  ", "Type,  ", "Serial,  ", "Brake,  "
        ));

        for (Bike b : bikes) {
            String wheelSize = b.getSize() == (int) b.getSize() ? Integer.toString((int) b.getSize()) : Double.toString(b.getSize());

            System.out.println(String.format(
                "%-4d" +
                "%-" + lengths[0] + "s" +
                "%-" + lengths[1] + "s" +
                "%-" + lengths[2] + "s" +
                "%-" + lengths[3] + "s" +
                "%s",
                b.getId(), b.getOwner() + ",  ", b.getType() + ",  ", b.getSerial() + ",  ", b.getBrake() + ",  ", wheelSize
            ));
            
        }
    }

    // 2
    private static void addNewBike() {
        System.out.print("Enter Bike owner name:\t\t\t");
        String owner = input.nextLine();

        System.out.print("Enter Bike type:\t\t\t\t");
        String type = input.nextLine();

        System.out.print("Enter Bike's serial number:\t\t");
        String serial = input.nextLine();

        boolean pass = false;
        Brakes brake = null;
        while (!pass) {
            System.out.print("Enter Bike's brake type:\t\t");
            try {
                brake = Brakes.valueOf(input.nextLine().toUpperCase());
                pass = true;
            } catch (Exception e) {
                System.out.println("Invalid brake type.");
            }
        }

        pass = false;
        double size = 0;
        while (!pass) {
            System.out.print("Enter Bike's wheel size:\t\t");
            try {
                size = Double.parseDouble(input.nextLine());
                pass = true;
            } catch (Exception e) {
                System.out.println("Invalid wheel size.");
            } 
        }

        bikes.add(new Bike(owner, type, serial, brake, size));

    }

    // 3
    private static void deleteBike() {
        displayAllBikes();
        System.out.println("Enter ID (0 to cancel)");
        boolean pass = false;
        int id = -1;
        while (!pass) {
            try {
                id = Integer.parseInt(input.nextLine());
                if (id == 0) return;
                if (bikes.get(id-1) == null) throw new Exception();
                bikes.remove(id-1);
                pass = true;
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
        
    }

    // 4
    private static void alterBike() {
        displayAllBikes();
        System.out.println("Enter ID (0 to cancel)");
        boolean pass = false;
        int index = -1;
        while (!pass) {
            try {
                System.out.print("> ");
                int id = Integer.parseInt(input.nextLine());
                if (id == 0) return;

                for (int i = 0; i < bikes.size(); i ++) {
                    if (bikes.get(i).getId() == id) {
                        index = i;
                    }
                }

                if (bikes.get(index) == null) throw new Exception();
                pass = true;
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
        pass = false;
        
        while (!pass) {
            System.out.println("Which Attribute?");
            System.out.print("> ");

            switch (input.nextLine().toLowerCase()) {
                case "owner":
                    System.out.println("New Value");
                    System.out.print("> ");
                    bikes.get(index).setOwner(input.nextLine());
                    pass = true;
                    break;
                case "type":
                    System.out.println("New Value");
                    System.out.print("> ");
                    bikes.get(index).setType(input.nextLine());
                    pass = true;
                    break;
                case "serial":
                    System.out.println("New Value");
                    System.out.print("> ");
                    bikes.get(index).setSerial(input.nextLine());
                    pass = true;
                    break;
                case "brake":
                    System.out.println("New Value");
                    while (!pass) {
                        try {
                            System.out.print("> ");
                            bikes.get(index).setBrake(Brakes.valueOf(input.nextLine().toUpperCase()));
                            pass = true;
                        } catch (Exception e) {
                            System.out.println("Invalid brake type.");
                        }
                    }
                    
                    break;
                case "wheel size":
                    System.out.println("New Value");
                    while (!pass) {
                        try {
                            System.out.print("> ");
                            bikes.get(index).setSize(Double.parseDouble(input.nextLine()));
                            pass = true;
                        } catch (Exception e) {
                            System.out.println("Invalid wheel size.");
                        }
                    }

                default:
                    System.out.println("Invalid attribute.");
                    break;
            }
        }

        System.out.println("Saved!");
    }

    // 5
    private static void debug() {
        System.out.println("All Bike objects:");
        for (int i = 0; i < bikes.size(); i ++) {
            System.out.println((i+1) + ". " + bikes.get(i));
        }
    }

    private static int max(int a, int b) {
        if (a > b) return a;
        else return b;
    }
}