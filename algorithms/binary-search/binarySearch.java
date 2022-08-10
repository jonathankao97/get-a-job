import java.io.*;
import java.util.*;

public class binarySearch {
    public static void main(String[] args) {
        System.out.println(solve(new int[] {}, 0, 0, 0));
        System.out.println(solve(new int[] { 1, 2, 3, 4, 5 }, 2, 0, 4));
        System.out.println(solve(new int[] { 1, 2, 3, 4, 5 }, 4, 0, 4));
        System.out.println(solve(new int[] { 1, 2, 3, 4, 5 }, 6, 0, 4));
        System.out.println(solve(new int[] { 1, 2, 3, 4, 5 }, -1, 0, 4));
        System.out.println(solve(new int[] { 1, 2, 3, 4, 7 }, 5, 0, 4));
    }

    public static int solve(int[] arr, int tgt, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end || mid >= arr.length) {
            return -1;
        }
        if (arr[mid] == tgt) {
            return mid;
        } else if (arr[mid] < tgt) {
            return solve(arr, tgt, mid + 1, end);
        } else {
            return solve(arr, tgt, start, mid - 1);
        }
    }
}
