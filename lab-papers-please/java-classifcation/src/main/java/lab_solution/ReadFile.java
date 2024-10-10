package lab_solution;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void read(String path) throws IOException
    {
        FileReader data = new FileReader(path);

        int i;
        while ((i = data.read()) != -1) //keep reading until eof
            System.out.print((char)i);

        data.close();
    }
}
