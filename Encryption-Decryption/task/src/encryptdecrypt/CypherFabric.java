package encryptdecrypt;

import java.util.Map;

public class CypherFabric {

    public static Cypher getCypher(Map<String, String> config) {
        String mode = config.get("-mode");
        String alg = config.get("-alg");
        if ("unicode".equals(alg)) {
            String stringKey = config.get("-key");
            int key = 0;
            if (stringKey != null) {
                key = Integer.parseInt(stringKey);
            }
            return new UnicodeCypher(mode, key);
        } else if ("shift".equals(alg)) {
            String stringKey = config.get("-key");
            int key = 0;
            if (stringKey != null) {
                key = Integer.parseInt(stringKey);
            }
            return new ShiftCypher(mode, key);
        } else {
            return null;
        }
    }
}
