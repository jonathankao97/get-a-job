public class RangeAddition370 {
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] buckets = new int[length + 1];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            buckets[start] += inc;
            buckets[end + 1] -= inc;
        }
        int[] soln = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += buckets[i];
            soln[i] = sum;
        }
        return soln;
    }
}
