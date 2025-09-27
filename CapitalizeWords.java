public class CapitalizeWords {
    public static String capitalizeWords(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";
        for (String word : words) {
                // take first letter, make uppercase, then add the rest
                result += word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(capitalizeWords("bobo loves haribo"));
    }
}
