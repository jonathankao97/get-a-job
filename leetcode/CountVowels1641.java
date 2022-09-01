import java.util.Arrays;

public class CountVowels1641 {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                for (int k = j + 1; k < dp.length; k++) {
                    dp[k] += dp[j];
                }
            }
        }
        int sum = 0;
        for (int d : dp) {
            sum += d;
        }
        return sum;
    }
}