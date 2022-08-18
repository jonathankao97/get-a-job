public class ValidPalindrome125 {

    public static boolean isPalindrome(String s) {
        String strip = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for (int i = 0; i < strip.length() / 2; i++) {
            if (strip.charAt(i) != strip.charAt(strip.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
