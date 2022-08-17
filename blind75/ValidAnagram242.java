public class ValidAnagram242 {
    public static boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        for (Character c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (Character c : t.toCharArray()) {
            cnt[c - 'a']--;
        }
        for (int c : cnt) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}