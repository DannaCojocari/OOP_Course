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


    private String carId;
    private CarType car_type;
    private PassengerType passenger_type;
    private Boolean isDining;
    private Integer consumptionRange; //between 10 and 50

    public Car(String carId, CarType car_type, PassengerType passenger_type, Boolean isDining, Integer consumptionRange) {
        this.carId = carId;
        this.car_type = car_type;
        this.passenger_type = passenger_type;
        this.isDining = isDining;
        this.consumptionRange = consumptionRange;
    }

    public String getCarId() {
        return carId;
    }

    public CarType getCar_type() {
        return car_type;
    }

    public PassengerType getPassenger_type() {
        return passenger_type;
    }

    public Boolean getIsDining() {
        return isDining;
    }

    public Integer getConsumptionRange() {
        return consumptionRange;
    }
}
