public class Partition416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[] dp1 = new int[sum + 1];
        dp1[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] dp2 = new int[sum + 1];
            for (int j = 0; j < dp2.length; j++) {
                if (dp1[j] == 1) {
                    dp2[j] = 1;
                    dp2[j + nums[i]] = 1;
                }
            }
            dp1 = dp2;
        }
        if (sum % 2 == 0) {
            return dp1[sum / 2] == 1;
        } else {
            return false;
        }
    }
}
