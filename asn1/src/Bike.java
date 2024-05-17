/**
 * @author Hin Lui 301571436
 * @version 1.0.0
 */
public class Bike {

    public static int number = 0;

    public int id;
    public String owner;
    public String type;
    public String serial;
    public String brake;
    public double size;

    public Bike(String owner, String type, String serial, String brake, double size) {
        this.id = ++ number;
        this.owner = owner;
        this.type = type;
        this.serial = serial;
        this.brake = brake;
        this.size = size;
    }
}