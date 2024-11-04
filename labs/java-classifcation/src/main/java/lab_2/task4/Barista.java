package lab_2.task4;

import java.util.ArrayList;
import java.util.Scanner;

public class Barista {
    enum Intensity {
        LIGHT,
        NORMAL,
        STRONG
    }

    private class Coffee {
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

    private class Cappuccino extends Coffee {
        private Integer mlOfMilk;

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

    private class Americano extends Coffee {
        private Integer mlOfWater;

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

    private class PumpkinSpiceLatte extends Cappuccino {
        private Integer mgOfPumpkinSpice;

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

    private class SyrupCappuccino extends Cappuccino {
        private SyrupType syrup;

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

    public static void main(String[] args) {
        Barista barista = new Barista();

        Scanner scanner = new Scanner(System.in);
        ArrayList<Coffee> coffees = new ArrayList<>();

        Boolean addOrder = true;
        while (addOrder) {
            String choice;
            String coffeeName = null;
            while (coffeeName == null) {
                System.out.println("Choose coffee type (Choose between the numbers below):");
                System.out.println("1. Cappuccino \n2. Americano \n3. PumpkinSpiceLatte \n4. SyrupCappuccino \n5. Exit");
                choice = scanner.nextLine();

                switch (choice) {
                    case "1": coffeeName = "Cappuccino"; break;
                    case "2": coffeeName = "Americano"; break;
                    case "3": coffeeName = "PumpkinSpiceLatte"; break;
                    case "4": coffeeName = "SyrupCappuccino"; break;
                    case "5": System.out.println("Exiting program."); return;
                    default: System.out.println("Invalid choice, please try again.");
                }
            }

            Intensity coffeeIntensity = null;
            while(coffeeIntensity == null) {
                System.out.println("Choose coffee intensity: ");
                System.out.println("1. Light \n2. Normal \n3. Strong \n4. Exit");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1": coffeeIntensity = Intensity.LIGHT; break;
                    case "2": coffeeIntensity = Intensity.NORMAL; break;
                    case "3": coffeeIntensity = Intensity.STRONG; break;
                    case "4": System.out.println("Exiting program."); return;
                    default: System.out.println("Invalid choice, please try again.");
                }
            }

            if (coffeeName.equals("Cappuccino") || coffeeName.equals("PumpkinSpiceLatte") || coffeeName.equals("SyrupCappuccino")) {
                Integer milkAmount = null;
                while (milkAmount == null) {
                    System.out.println("Choose amount of milk: ");
                    System.out.println("1. 200ml \n2. 250ml \n3. 300ml \n4. Exit");
                    choice = scanner.nextLine();
                    switch (choice) {
                        case "1": milkAmount = 200; break;
                        case "2": milkAmount = 250; break;
                        case "3": milkAmount = 300; break;
                        case "4": System.out.println("Exiting program."); return;
                        default: System.out.println("Invalid choice, please try again.");
                    }
                }

                if (coffeeName.equals("Cappuccino")) {
                    Coffee cappuccino = barista.new Cappuccino(coffeeIntensity, milkAmount);
                    coffees.add(cappuccino);
                } else if (coffeeName.equals("PumpkinSpiceLatte")) {
                    Integer pumpkinSpice = null;
                    while (pumpkinSpice == null) {
                        System.out.println("Choose amount of pumpkin spice: ");
                        System.out.println("1. 5mg \n2. 10mg \n3. 15mg \n4. Exit");
                        choice = scanner.nextLine();
                        switch (choice) {
                            case "1": pumpkinSpice = 5; break;
                            case "2": pumpkinSpice = 10; break;
                            case "3": pumpkinSpice = 15; break;
                            case "4": System.out.println("Exiting program."); return;
                            default: System.out.println("Invalid choice, please try again.");
                        }
                    }

                    Coffee pumpkinSpiceLatte = barista.new PumpkinSpiceLatte(coffeeIntensity, milkAmount, pumpkinSpice);
                    coffees.add(pumpkinSpiceLatte);
                } else {
                    SyrupType syrup = null;
                    while (syrup == null) {
                        System.out.println("Choose syrup for cappuccino:");
                        System.out.println("1. Macadamia \n2. Vanilla \n3. Coconut \n4. Caramel \n5. Chocolate \n6. Popcorn \n7. Exit");
                        choice = scanner.nextLine();
                        switch (choice) {
                            case "1": syrup = SyrupType.MACADAMIA; break;
                            case "2": syrup = SyrupType.VANILLA; break;
                            case "3": syrup = SyrupType.COCONUT; break;
                            case "4": syrup = SyrupType.CARAMEL; break;
                            case "5": syrup = SyrupType.CHOCOLATE; break;
                            case "6": syrup = SyrupType.POPCORN; break;
                            case "7": System.out.println("Exiting program."); return;
                            default: System.out.println("Invalid choice, please try again.");
                        }
                    }

                    Coffee syrupCappuccino = barista.new SyrupCappuccino(coffeeIntensity, milkAmount, syrup);
                    coffees.add(syrupCappuccino);
                }
            } else {
                Integer waterAmount = null;
                while (waterAmount == null) {
                    System.out.println("Choose amount of water: ");
                    System.out.println("1. 10ml \n2. 15ml \n3. 20ml \n4. Exit");
                    choice = scanner.nextLine();
                    switch (choice) {
                        case "1": waterAmount = 10; break;
                        case "2": waterAmount = 15; break;
                        case "3": waterAmount = 20; break;
                        case "4": System.out.println("Exiting program."); return;
                        default: System.out.println("Invalid choice, please try again."); break;
                    }
                }

                Coffee americano = barista.new Americano(coffeeIntensity, waterAmount);
                coffees.add(americano);
            }

            System.out.println("If you want to place another order press 1, if not press any other key");
            choice = scanner.nextLine();
            addOrder = choice.equals("1");
        }

        int orderNumber = 1;
        for (Coffee coffee : coffees) {
            System.out.println("Order nr." + orderNumber);
            coffee.printCoffeeDetails();
            System.out.println("Recipe:");
            if (coffee instanceof Cappuccino cappuccino) {
                if (cappuccino instanceof PumpkinSpiceLatte pumpkinSpiceLatte) {
                    pumpkinSpiceLatte.recipePumpkinSpiceLatte();
                } else if (cappuccino instanceof SyrupCappuccino syrupCappuccino) {
                    syrupCappuccino.recipeSyrupCappuccino();
                } else {
                    cappuccino.recipeCappuccino();
                }
            } else if (coffee instanceof Americano americano) {
                americano.recipeAmericano();
            }
            System.out.println();
            orderNumber++;
        }

        scanner.close();

    }
}
