import java.util.Arrays;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int coin : coins) {
                int next = i + coin;
                if (0 <= next && next <= amount) {
                    dp[next] = Math.min(dp[next], dp[i] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
