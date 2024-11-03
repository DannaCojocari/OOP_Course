package lab_2.task3;

import java.sql.SQLOutput;

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

    //method that gets overrided in the child classes
    public void printCoffeeDetails() {
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }

    //Coffee recipe
    public final Coffee recipeCoffee() {
        System.out.println("Making " + name);
        System.out.println("Intensity set to " + coffeeIntensity);
        return this;
    }
}

class Cappuccino extends Coffee {
    private Integer mlOfMilk;

    public Cappuccino(Intensity coffeeIntensity, Integer mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
        name = "Cappuccino";
    }

    //new property
    public Integer getMlOfMilk() {
        return mlOfMilk;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(name + " milk: " + mlOfMilk + " ml");
    }

    //Cappuccino recipe
    public final Cappuccino recipeCappuccino() {
        recipeCoffee();
        System.out.println("Adding " + mlOfMilk + " mls of milk");
        return this;
    }
}

class Americano extends Coffee {
    private Integer mlOfWater;

    public Americano(Intensity coffeeIntensity, Integer mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
        name = "Americano";
    }

    //new property
    public Integer getMlOfWater() {
        return mlOfWater;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(name + " water: " + mlOfWater + " ml");
    }

    //Americano recipe
    public final Americano recipeAmericano() {
        recipeCoffee();
        System.out.println("Adding " + mlOfWater + " mls of water");
        return this;
    }
}

class PumpkinSpiceLatte extends Cappuccino {
    private Integer mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity coffeeIntensity, Integer mlOfMilk, Integer mgOfPumpkinSpice) {
        super(coffeeIntensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        name = "Pumpkin Spice Latte";
    }

    //new property
    public Integer getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(name + " spice: " + mgOfPumpkinSpice + " mg");
    }

    //Pumpkin Spice Latte recipe
    public final PumpkinSpiceLatte recipePumpkinSpiceLatte() {
        recipeCappuccino();
        System.out.println("Adding " + mgOfPumpkinSpice + " mgs of pumpkin spice");
        return this;
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
        name = "Syrup Cappuccino";
    }

    //new property
    public SyrupType getSyrup() {
        return syrup;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(name + " syrup: " + syrup);
    }

    //Syrup Cappuccino property
    public final SyrupCappuccino recipeSyrupCappuccino() {
        recipeCappuccino();
        System.out.println("Adding " + syrup + " syrup");
        return this;
    }
}

public class Barista {
    public static void main(String[] args) {
        //Cappuccino recipe
        //Upcasting
        Coffee cappuccino = new Cappuccino(Intensity.LIGHT, 100);
        //Downcasting
        Cappuccino addCappuccino = (Cappuccino) cappuccino;
        addCappuccino.recipeCappuccino();

        //Pumpkin Spice Latte recipe
        System.out.println();
        Coffee pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 120, 5);
        Cappuccino addLatte1 = (Cappuccino) pumpkinSpiceLatte;
        PumpkinSpiceLatte addLatte2 = (PumpkinSpiceLatte)addLatte1;
        addLatte2.recipePumpkinSpiceLatte();


        //Americano
        System.out.println();
        Coffee americano = new Americano(Intensity.STRONG, 10);
        Americano addAmericano = (Americano)americano;
        addAmericano.recipeAmericano();

        //SyrupCappuccino
        System.out.println();
        Coffee syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 60, SyrupType.CARAMEL);
        Cappuccino addSyrupCappuccino1 = (Cappuccino)syrupCappuccino;
        SyrupCappuccino addSyrupCappuccino2 = (SyrupCappuccino)addSyrupCappuccino1;
        addSyrupCappuccino2.recipeSyrupCappuccino();
    }
}



