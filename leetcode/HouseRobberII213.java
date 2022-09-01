import java.io.*;
import java.util.*;

public class HouseRobberII213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int pass1 = i - 1 >= 0 ? dp1[i - 1] : 0;
            int pass2 = i - 1 >= 0 ? dp2[i - 1] : 0;
            int rob1 = i - 2 >= 0 ? dp1[i - 2] : 0;
            int rob2 = i - 2 >= 0 ? dp2[i - 2] : 0;
            if (i != 0) {
                dp1[i] = Math.max(pass1, rob1 + nums[i]);
            }
            if (i != nums.length - 1) {
                dp2[i] = Math.max(pass2, rob2 + nums[i]);
            }
        }
        return Math.max(dp1[nums.length - 1], dp2[nums.length - 2]);
    }

}