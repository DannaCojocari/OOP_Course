package lab_solution;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //using the read class and function to extract the data from the file
        JsonNode data = ReadFile.read("C:\\Users\\user\\IdeaProjects\\OOP_Lab2\\lab-papers-please\\java-classifcation\\src\\main\\resources\\test-input.json");

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

            //printing the results, also to check if the data is being processed correctly
            int id = person.getId();
            person.get();
            System.out.println("id= " + id);
            System.out.println(entry.toPrettyString());
        }
    }
}
