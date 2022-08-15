public class NumPairs1010 {
    public static int numPairsDivisibleBy60(int[] time) {
        int[] buckets = new int[60];
        int soln = 0;
        for (int song : time) {
            int res = song % 60;
            if (res != 0) {
                soln += buckets[60 - res];
            } else {
                soln += buckets[res];
            }
            buckets[res]++;
        }
        return soln;
    }

}
