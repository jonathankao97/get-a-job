import java.io.*;
import java.util.*;

public class ArrayList {

    public int[] arr;
    public int idx;

    public ArrayList() {
        this.arr = new int[1];
    }

    public void insert(int elem) {
        if (idx == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[idx++] = elem;
    }

    public int lookup(int idx) {
        return arr[idx];
    }

    public int size() {
        return this.arr.length;
    }

    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arr.insert((int) Math.pow(i, 2));
            System.out.println(i + " " + arr.size());
        }
    }
}