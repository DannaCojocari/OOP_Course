package lab_solution;

public class Person {
    private int id;
    private boolean humanoid;
    private String planet;
    private int age;
    private String[] traits;

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setHumanoid(boolean humanoid) {
        this.humanoid = humanoid;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTraits(String[] traits) {
        this.traits = traits;
    }

    void set(boolean humanoid, String planet, int age, String[] traits) {
        this.humanoid = humanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    //getters
    public int getId() {
        return id;
    }

    public boolean getHumaoid() {
        return humanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public int getAge() {
        return age;
    }

    public String[] getTraits() {
        return traits;
    }

    void get() {
        System.out.println("Id: " + id);
        System.out.println("Is Humanoid: " + humanoid);
        System.out.println("Planet: " + planet);
        System.out.println("Age: " + age);
        System.out.print("Traits: ");
        for (String trait : traits) {
            System.out.print(trait + " ");
        }
        System.out.println();
    }
}
