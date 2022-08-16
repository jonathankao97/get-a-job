import java.io.*;
import java.util.*;

public class SubarraySums974 {
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int sum = 0;
        int soln = 0;
        count.put(0, 1);
        for (int num : nums) {
            sum = (sum + num) % k;
            if (sum < 0) {
                sum = (sum + k) % k;
            }
            int modCount = count.getOrDefault(sum, 0);
            soln += modCount;
            count.put(sum, modCount + 1);
        }
        return soln;
    }
}