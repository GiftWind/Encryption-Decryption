package encryptdecrypt;

public class ShiftCypher implements Cypher {
    String mode;
    int key;

    public ShiftCypher(String mode, int key) {
        this.mode = mode;
        this.key = key;
    }

    @Override
    public String transform(String data) {
        final String alphabetLowercase = "abcdefghijklmnopqrstuvwxyz";
        final String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] letters = data.toCharArray();
        StringBuilder result = new StringBuilder();
        int currentIndex, shiftedIndex;
        for (char ch: letters) {
            if (alphabetLowercase.contains(String.valueOf(ch))) {
                currentIndex = alphabetLowercase.indexOf(ch);
                if ("enc".equals(mode)) {
                    shiftedIndex = (currentIndex + key) % 26;
                } else {
                    shiftedIndex = (currentIndex - (key % 26) + 26) % 26;
                }
                result.append(alphabetLowercase.charAt(shiftedIndex));
            } else if (alphabetUpperCase.contains(String.valueOf(ch))){
                currentIndex = alphabetLowercase.indexOf(ch);
                if ("enc".equals(mode)) {
                    shiftedIndex = (currentIndex + key) % 26;
                } else {
                    shiftedIndex = (currentIndex - (key % 26) + 26) % 26;
                }
                result.append(alphabetLowercase.charAt(shiftedIndex));
            } else {
                result.append(ch);
            }
        }
        return String.valueOf(result);
    }
}
