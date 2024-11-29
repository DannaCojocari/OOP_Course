package lab_3.task2;

public class GasStation implements Refuelable{
    private static Integer gasStation = 0;

    public void countGasStation() {
        gasStation++;
    }

    public Integer getGasStation() {
        return gasStation;
    }

    @Override
    public void refuel(String carId) {
        System.out.println("Refueling gas car " + carId + ".");
        countGasStation();
    }
}
