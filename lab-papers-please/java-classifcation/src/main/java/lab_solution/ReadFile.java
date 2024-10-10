package lab_solution;
import java.io.FileReader;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFile {
    public static void read(String path) throws IOException
    {
        // ObjectMapper instance - JSON parsing
        ObjectMapper mapper = new ObjectMapper();

        // parsing the file into a JsonNode object
        FileReader file = new FileReader(path);
        JsonNode data = mapper.readTree(file).get("data");

        //printing each json object separately
        for (JsonNode entry : data) {
            System.out.println(entry.toPrettyString());
        }
    }
}
