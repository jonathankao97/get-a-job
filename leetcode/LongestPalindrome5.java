import java.io.*;
import java.util.*;

public class LongestPalindrome5 {
    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length() + 1];
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                if (j == 1) {
                    dp[i][j] = true;
                } else if (j == 2 && i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][j] = true;
                } else if (i + j - 1 < s.length() && s.charAt(i) == s.charAt(i + j - 1) && dp[i + 1][j - 2]) {
                    dp[i][j] = true;
                }
            }
        }
        for (int j = s.length(); j >= 1; j--) {
            for (int i = 0; i < s.length(); i++) {
                if (dp[i][j]) {
                    return s.substring(i, i + j);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }
}