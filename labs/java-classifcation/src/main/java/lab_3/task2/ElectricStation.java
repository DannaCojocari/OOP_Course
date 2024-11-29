package lab_3.task2;

public class ElectricStation implements Refuelable{
    private static Integer electricCar = 0;

    public void countElectricCar() {
        electricCar++;
    }

    public Integer getElectricCar() {
        return electricCar;
    }

    @Override
    public void refuel(String carId) {
        System.out.println("Refueling electric car " + carId + ".");
        countElectricCar();
    }
}
