import java.io.*;
import java.util.*;

public class TrapWater42 {
    public int trap(int[] height) {
        int[] bounds = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            bounds[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            bounds[i] = Math.min(bounds[i], max);
            max = Math.max(max, height[i]);
        }
        int soln = 0;
        for (int i = 0; i < height.length; i++) {
            if (bounds[i] > height[i]) {
                soln += (bounds[i] - height[i]);
            }
        }
        return soln;
    }

}