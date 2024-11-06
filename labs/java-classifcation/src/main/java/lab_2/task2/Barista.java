package lab_2.task2;

enum Intensity {
    LIGHT,
    NORMAL,
    STRONG
}

class Coffee {
    private Intensity coffeeIntensity;
    public String name;

    public Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
        name = "Coffee";
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    public void printCoffeeDetails() {
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }
}

class Cappuccino extends Coffee {
    private Integer mlOfMilk;

    public Cappuccino(Intensity coffeeIntensity, Integer mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
        name = "Cappuccino";
    }

    public Integer getMlOfMilk() {
        return mlOfMilk;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(name + " milk: " + mlOfMilk + " ml");
    }
}

class Americano extends Coffee {
    private Integer mlOfWater;

    public Americano(Intensity coffeeIntensity, Integer mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
        name = "Americano";
    }

    public Integer getMlOfWater() {
        return mlOfWater;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(name + " water: " + mlOfWater + " ml");
    }
}

class PumpkinSpiceLatte extends Cappuccino {
    private Integer mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity coffeeIntensity, Integer mlOfMilk, Integer mgOfPumpkinSpice) {
        super(coffeeIntensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        name = "PumpkinSpiceLatte";
    }

    public Integer getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(name + " spice: " + mgOfPumpkinSpice + " mg");
    }
}

enum SyrupType {
    MACADAMIA,
    VANILLA,
    COCONUT,
    CARAMEL,
    CHOCOLATE,
    POPCORN
}

class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;

    public SyrupCappuccino(Intensity coffeeIntensity, Integer mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
        name = "SyrupCappuccino";
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(name + " syrup: " + syrup);
    }
}

public class Barista {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.LIGHT, 50);
        cappuccino.printCoffeeDetails();

        System.out.println("\n");
        PumpkinSpiceLatte latte = new PumpkinSpiceLatte(Intensity.NORMAL, 70, 5);
        latte.printCoffeeDetails();

        System.out.println("\n");
        Americano americano = new Americano(Intensity.STRONG, 5);
        americano.printCoffeeDetails();

        System.out.println("\n");
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 50, SyrupType.COCONUT);
        syrupCappuccino.printCoffeeDetails();
    }
}