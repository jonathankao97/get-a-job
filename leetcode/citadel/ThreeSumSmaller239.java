import java.io.*;
import java.util.*;

public class ThreeSumSmaller239 {

    public static void main(String[] args) {
        threeSumSmaller(new int[] { 1, -2, 2, 1, 0 }, 1);
    }

    public static int threeSumSmaller(int[] nums, int target) {
        HashMap<Integer, Integer> singleton = new HashMap<>();
        HashMap<Integer, Integer> pair = new HashMap<>();
        HashMap<Integer, Integer> triplet = new HashMap<>();
        for (int num : nums) {
            for (int sum : pair.keySet()) {
                int numPairs = pair.get(sum);
                triplet.put(sum + num, triplet.getOrDefault(sum + num, 0) + numPairs);
            }
            for (int sum : singleton.keySet()) {
                int numSingles = singleton.get(sum);
                pair.put(sum + num, pair.getOrDefault(sum + num, 0) + numSingles);
            }
            singleton.put(num, singleton.getOrDefault(num, 0) + 1);
        }
        int soln = 0;
        for (int sum : triplet.keySet()) {
            if (sum < target) {
                soln += triplet.get(sum);
            }
        }
        return soln;
    }

}
