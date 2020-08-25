package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Outer {
    public static void out(String result, Map<String, String> config) {
        if (config.get("-out") == null) {
            System.out.println(result);
        } else {
            File outputFile = new File(config.get("-out"));
            try (FileWriter fileWriter = new FileWriter(outputFile, false);) {
                fileWriter.write(result);
            } catch (IOException e) {
                System.out.println("Error: no such file");
            }
        }
    }
}
