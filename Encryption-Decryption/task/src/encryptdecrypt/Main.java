package encryptdecrypt;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> config = Parser.parseInput(args);
        String result = "";
        String data = config.get("-data");
        Cypher cypher = CypherFabric.getCypher(config);
        result = cypher.transform(data);
        Outer.out(result, config);
    }
}
