package lab_solution;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        String[] traits1 = {"Intelligent", "Curious", "Empathetic"};
        person1.set(true, "Earth", 25, traits1);
        person1.get();

        Person person2 = new Person();
        String[] traits2 = {"Tall"};
        person2.set(false, "Star Wars", 525, traits2);
        person2.get();

    }
}
