package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, String> parseInput(String[] args) {
        Map<String, String> config = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                config.put("-mode", args[i + 1]);
            } else if ("-key".equals(args[i])) {
                config.put("-key", args[i + 1]);
            } else if ("-data".equals(args[i])) {
                config.put("-data", args[i + 1]);
            } else if ("-in".equals(args[i])) {
                config.put("-in", args[i + 1]);
            } else if ("-out".equals(args[i])) {
                config.put("-out", args[i + 1]);
            } else if ("-alg".equals(args[i])) {
                config.put("-alg", args[i + 1]);
            }
        }
        if (config.get("-mode") == null) {
            config.put("-mode", "enc");
        }
        if (config.get("-key") == null) {
            config.put("-key", "0");
        }
        if (config.get("-data") == null && config.get("-in") == null) {
            config.put("-data", "");
        }
        if (config.get("-in") != null); {
            String data = "";
            String inputFile = config.get("-in");
            try {
                data = String.valueOf(Files.readAllLines(Paths.get(inputFile)));
                data = data.substring(1, data.length() - 1);
            } catch (IOException e) {
                System.out.println("Error: no such file");
            }
            config.put("-data", data);
        }
        if (config.get("-alg") == null) {
            config.put("-alg", "shift");
        }
        return config;
    }
}
