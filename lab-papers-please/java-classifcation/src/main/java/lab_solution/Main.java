package lab_solution;
import com.fasterxml.jackson.databind.JsonNode;
//import oop.practice.Universe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //using the read class and function to extract the data from the file
        JsonNode data = ReadFile.read("C:\\Users\\user\\IdeaProjects\\OOP_Lab2\\lab-papers-please\\java-classifcation\\src\\main\\java\\lab_solution\\test.json");

        //mapping the json to the person class
        for (JsonNode entry : data) {
            Person person = new Person();

            if (entry.get("id") != null )  {
                person.setId(entry.get("id").asInt());
            }
            if (entry.get("planet") != null )  {
                person.setPlanet(entry.get("planet").asText());
            }
            if (entry.get("humanoid") != null )  {
                person.setHumanoid(entry.get("humanoid").asBoolean());
            }
            if (entry.get("traits") != null) {
                JsonNode traitsNode = entry.get("traits");
                String[] traits = new String[traitsNode.size()];
                for (int i = 0; i < traitsNode.size(); i++) {
                    traits[i] = traitsNode.get(i).asText();
                }
                person.setTraits(traits);
            }
            if (entry.get("age") != null )  {

                person.setAge(entry.get("age").asInt());
            }

            person.get();


            boolean classified = false;

            // Classifying the planet
            if (person.getPlanet() != null)  {
                switch (person.getPlanet()) {
                    case "Kashyyk", "Endor" -> {
                        System.out.println();
                        System.out.println("Star Wars");
                        classified = true;
                    }
                    case "Asgard" -> {
                        System.out.println();
                        System.out.println("Marvel");
                        classified = true;
                    }
                    case "Betelgeuse", "Vogsphere" -> {
                        System.out.println();
                        System.out.println("Hitchhiker");
                        classified = true;
                    }
                    case "Earth" -> {
                        System.out.println();
                        System.out.println("Lord of the rings");
                        classified = true;
                    }
                }
            }

            // Classifying by traits
            if (!classified && person.getTraits() != null) {
                if (person.containsTrait(person.getTraits(), "HAIRY")) {
                    System.out.println();
                    System.out.println("Star Wars");
                    classified = true;
                } else if (person.containsTrait(person.getTraits(), "BLONDE")) {
                    System.out.println();
                    System.out.println("Marvel");
                    classified = true;
                } else if (person.containsTrait(person.getTraits(), "EXTRA_ARMS") || person.containsTrait(person.getTraits(), "EXTRA_HEAD") || person.containsTrait(person.getTraits(), "GREEN")) {
                    System.out.println();
                    System.out.println("Hitchhiker");
                    classified = true;
                } else if (person.containsTrait(person.getTraits(), "POINTY-EYES")) {
                    System.out.println();
                    System.out.println("Lord of the rings");
                    classified = true;
                }  else if (person.containsTrait(person.getTraits(), "SHORT") && person.containsTrait(person.getTraits(), "BULKY")) {
                    System.out.println();
                    System.out.println("Lord of the rings");
                    classified = true;
                } else if (person.containsTrait(person.getTraits(), "TALL")) {
                    if (!person.getHumanoid()) {
                        System.out.println();
                        System.out.println("Star Wars");
                        classified = true;
                    } else if (person.getHumanoid() || person.getAge() > 400) {
                        System.out.println();
                        System.out.println("Marvel");
                        classified = true;
                    }
                } else if (person.containsTrait(person.getTraits(), "SHORT")) {
                    if (!person.getHumanoid()) {
                        System.out.println();
                        System.out.println("Star Wars");
                        classified = true;
                    } else if (person.getHumanoid() || person.getAge() > 60) {
                        System.out.println();
                        System.out.println("Lord of the rings");
                        classified = true;
                    }
                } else if (person.containsTrait(person.getTraits(), "BULKY")) {
                    if (!person.getHumanoid()) {
                        System.out.println();
                        System.out.println("Hitchhiker");
                        classified = true;
                    } else if (person.getHumanoid()) {
                        System.out.println();
                        System.out.println("Lord of the rings");
                        classified = true;
                    }
                }
            }

            // Classifying by age
            if (!classified && person.getAge() > 5000)  {
                System.out.println();
                System.out.println("Lord of the rings");
                classified = true;
            }

            // Default
            if (!classified) {
                System.out.println();
                System.out.println("Unclassified");
            }
        }



    }
}
