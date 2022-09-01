import java.io.*;
import java.util.*;

public class DecodeWays91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                continue;
            }
            dp[i + 1] += dp[i];
            if (i != s.length() - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                dp[i + 2] += dp[i];
            }
        }
        return dp[s.length()];
    }

}