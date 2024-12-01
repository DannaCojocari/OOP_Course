package lab_3.task3;

public class Car {
    public enum CarType {
        ELECTRIC,
        GAS
    }

    public enum PassengerType {
        PEOPLE,
        ROBOTS
    }


    private String id;
    private CarType type;
    private PassengerType passengers;
    private Boolean isDining;
    private Integer consumption; //between 10 and 50

    public Car() {

    }

    public Car(String id, CarType type, PassengerType passengers, Boolean isDining, Integer consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public void setPassengers(PassengerType passengers) {
        this.passengers = passengers;
    }

    public void setDining(Boolean dining) {
        isDining = dining;
    }

    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }

    public String getId() {
        return id;
    }

    public CarType getType() {
        return type;
    }

    public PassengerType getPassengers() {
        return passengers;
    }

    public Boolean getIsDining() {
        return isDining;
    }

    public Integer getConsumption() {
        return consumption;
    }
}
