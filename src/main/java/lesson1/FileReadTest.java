package lesson1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class FileReadTest {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input.txt"));
            FileWriter writer = new FileWriter("src/main/resources/output.txt");
            String txt = "", s = "";
            while ((s = reader.readLine()) != null) {
                txt += s + "\n";
            }
            System.out.println(txt.toUpperCase().replaceAll("I", "!!!!!!!"));

            writer.write(txt);

            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
