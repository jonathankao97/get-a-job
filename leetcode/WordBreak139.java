import java.io.*;
import java.util.*;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (dp[i] != 1) {
                continue;
            }
            for (String word : wordDict) {
                if (i + word.length() > s.length()) {
                    continue;
                }
                if (s.substring(i, i + word.length()).equals(word)) {
                    dp[i + word.length()] = 1;
                }
            }
        }
        return dp[s.length()] == 1;
    }

}