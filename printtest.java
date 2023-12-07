import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class printtest {
    public static void main(String[] args) {
        String filePath = "test.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Read each line from the file until the end is reached
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
