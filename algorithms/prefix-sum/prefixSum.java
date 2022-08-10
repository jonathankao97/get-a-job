public class prefixSum {
    public static void main(String[] args) {
        int[] pfx = solve(new int[] { -10, 10, -20, 20, 3, 7, -2 });
        System.out.println(pfx[2] - pfx[0]);
        System.out.println(pfx[3] - pfx[0]);
        System.out.println(pfx[3] - pfx[1]);
    }

    public static int[] solve(int[] arr) {
        int[] soln = new int[arr.length + 1];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            soln[i] = sum;
            sum += arr[i];
        }
        soln[arr.length] = sum;
        return soln;
    }
}