abstract class Caesar {
    public static String encrypt(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            result.append((char) (character + offset));
        }
        return result.toString();
    }
}
