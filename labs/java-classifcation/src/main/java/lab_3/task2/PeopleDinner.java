package lab_3.task2;

public class PeopleDinner implements Dineable{
    private static Integer people = 0;

    public void countPeople() {
        people++;
    }

    public Integer getPeople() {
        return people;
    }

    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving people dinner to car " + carId + ".");
        countPeople();
    }
}
