import java.io.*;
import java.util.*;

public class CountSay38 {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String rec = countAndSay(n - 1) + "#";
            char digit = rec.charAt(0);
            int repeat = 1;
            String soln = "";
            for (int i = 1; i < rec.length(); i++) {
                if (rec.charAt(i) != digit) {
                    soln += repeat;
                    soln += digit;
                    repeat = 0;
                    digit = rec.charAt(i);
                }
                repeat++;
            }
            return soln;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 4; i++) {
            System.out.println(countAndSay(i));
        }
    }
}