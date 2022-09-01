import java.io.*;
import java.util.*;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        int[] buckets = new int[10001];
        int[] duplicates = new int[10001];
        for (int[] interval : intervals) {
            if (interval[0] == interval[1]) {
                duplicates[interval[0]]++;
            }
            buckets[interval[0]]++;
            buckets[interval[1]]--;
        }
        ArrayList<int[]> soln = new ArrayList<>();
        int start = -1;
        int sum = 0;
        for (int i = 0; i < buckets.length; i++) {
            sum += buckets[i];
            if (start == -1 && sum != 0) {
                start = i;
            } else if (start == -1 && duplicates[i] != 0) {
                soln.add(new int[] { i, i });
            } else if (start != -1 && sum == 0) {
                soln.add(new int[] { start, i });
                start = -1;
            }
        }
        int[][] ret = new int[soln.size()][2];
        for (int i = 0; i < soln.size(); i++) {
            ret[i] = soln.get(i);
        }
        return ret;
    }
}