/**
 * This class constructs the Bike object.
 * @author Hin Lui 301571436
 * @version 1.0.0
 */
public class Bike {

    private static int number = 0;

    private int id;
    private String owner;
    private String type;
    private String serial;
    private Brakes brake;
    private double size;

    public Bike(String owner, String type, String serial, Brakes brake, double size) {
        this.id = ++ number;
        this.owner = owner;
        this.type = type;
        this.serial = serial;
        this.brake = brake;
        this.size = size;
    }

    @Override
    public String toString() {
        if (size == (int) size) {
            return String.format("ca.sfu.cmpt213.as1.Bike[Id:%d, Owner:%s, type:%s, Serial:%s, Brake:%s, WheelSize:%d]", id, owner, type, serial, brake, (int) size);
        }
        else {
            return String.format("ca.sfu.cmpt213.as1.Bike[Id:%d, Owner:%s, type:%s, Serial:%s, Brake:%s, WheelSize:" + size + "]", id, owner, type, serial, brake);
        }
    }

    public int getId() {
        return id;
    }

    public String getOwner(){
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Brakes getBrake() {
        return brake;
    }

    public void setBrake(Brakes brake) {
        this.brake = brake;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}