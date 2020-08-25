package encryptdecrypt;

public class UnicodeCypher implements Cypher {
    String mode;
    int key;

    public UnicodeCypher(String mode, int key) {
        this.mode = mode;
        this.key = key;
    }

    @Override
    public String transform(String data) {
        char[] letters = data.toCharArray();
        StringBuilder result = new StringBuilder();
        if ("enc".equals(mode)) {
            for (char ch: letters) {
                result.append((char)(ch + key));
            }
            return String.valueOf(result);
        } else {
            for (char ch: letters) {
                result.append((char)(ch - key));
            }
            return String.valueOf(result);
        }
    }
}
