import java.io.*;
import java.util.*;

public class RandomPick528 {
    public TreeMap<Integer, Integer> mp;
    public int sum;

    public RandomPick528(int[] w) {
        this.mp = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            mp.put(sum, i);
        }
        this.sum = sum;
    }

    public int pickIndex() {
        int rand = (int) Math.floor(Math.random() * sum);
        return mp.higherEntry(rand).getValue();
    }
}