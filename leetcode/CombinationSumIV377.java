import java.io.*;
import java.util.*;

public class CombinatiomSumIV377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int num : nums) {
                if (i + num > target) {
                    continue;
                }
                dp[i + num] += dp[i];
            }
        }
        return dp[target];
    }
}