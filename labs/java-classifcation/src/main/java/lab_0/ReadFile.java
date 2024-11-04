package lab_0;
import java.io.FileReader;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Scanner;

public class ReadFile {
    public static JsonNode read(String path) throws IOException
    {
        // ObjectMapper instance - JSON parsing
        ObjectMapper mapper = new ObjectMapper();

        // parsing the file into a JsonNode object
        FileReader file = new FileReader(path);

        return mapper.readTree(file).get("data");
    }

    public String readFileIntoString(String path) throws IOException {

        File file = new File(path);
        StringBuilder fileContents = new StringBuilder((int)file.length());

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return fileContents.toString();
        }
    }
}
