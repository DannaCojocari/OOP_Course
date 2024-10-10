package lab_solution;



public class Person {
    private static int id_Count = 0;
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private String[] traits;

    public Person() {
        this.id = ++id_Count;
    }

    void set(boolean isHumanoid, String planet, int age, String[] traits) {
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }


    void get() {
        System.out.println("Id: " + id);
        System.out.println("Is Humanoid: " + isHumanoid);
        System.out.println("Planet: " + planet);
        System.out.println("Age: " + age);
        System.out.print("Traits: ");
        for (String trait : traits) {
            System.out.print(trait + " ");
        }
        System.out.println();
    }
}
