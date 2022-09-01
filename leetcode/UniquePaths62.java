import java.io.*;
import java.util.*;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        double soln = factorial(m + n - 2) / (factorial(m - 1) * factorial(n - 1));
        return (int) Math.round(soln);
    }

    public double factorial(int m) {
        double ans = 1;
        for (int i = 1; i <= m; i++) {
            ans *= i;
        }
        return ans;
    }
}