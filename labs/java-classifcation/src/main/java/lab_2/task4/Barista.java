package lab_2.task4;

public class Barista {
    enum Intensity {
        LIGHT,
        NORMAL,
        STRONG
    }

    class Coffee {
        protected String name;
        protected Intensity coffeeIntensity;

        public Coffee(Intensity coffeeIntensity) {
            this.coffeeIntensity = coffeeIntensity;
            name = "Coffee";
        }

        //method that gets overrided in the child classes
        public void printCoffeeDetails() {
            System.out.println("Name: " + name);
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
        private final Integer mlOfMilk;

        public Cappuccino(Intensity coffeeIntensity, Integer mlOfMilk) {
            super(coffeeIntensity);
            this.mlOfMilk = mlOfMilk;
            name = "Cappuccino";
        }

        @Override
        public void printCoffeeDetails() {
            super.printCoffeeDetails();
            System.out.println("Milk: " + mlOfMilk + " ml");
        }

        //Cappuccino recipe
        public final Cappuccino recipeCappuccino() {
            recipeCoffee();
            System.out.println("Adding " + mlOfMilk + " mls of milk");
            return this;
        }
    }

     class Americano extends Coffee {
        private final Integer mlOfWater;

        public Americano(Intensity coffeeIntensity, Integer mlOfWater) {
            super(coffeeIntensity);
            this.mlOfWater = mlOfWater;
            name = "Americano";
        }

        @Override
        public void printCoffeeDetails() {
            super.printCoffeeDetails();
            System.out.println("Water: " + mlOfWater + " ml");
        }

        //Americano recipe
        public final Americano recipeAmericano() {
            recipeCoffee();
            System.out.println("Adding " + mlOfWater + " mls of water");
            return this;
        }
    }

     class PumpkinSpiceLatte extends Cappuccino {
        private final Integer mgOfPumpkinSpice;

        public PumpkinSpiceLatte(Intensity coffeeIntensity, Integer mlOfMilk, Integer mgOfPumpkinSpice) {
            super(coffeeIntensity, mlOfMilk);
            this.mgOfPumpkinSpice = mgOfPumpkinSpice;
            name = "Pumpkin Spice Latte";
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
        private final SyrupType syrup;

        public SyrupCappuccino(Intensity coffeeIntensity, Integer mlOfMilk, SyrupType syrup) {
            super(coffeeIntensity, mlOfMilk);
            this.syrup = syrup;
            name = "Syrup Cappuccino";
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
}
