public class HouseRobber198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else if (i == 1) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
        }
        return dp[nums.length - 1];
    }

}
