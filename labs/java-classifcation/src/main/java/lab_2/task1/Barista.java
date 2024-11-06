package lab_2.task1;

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
}
