import java.io.*;
import java.util.*;

public class ValidParen20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                Character next = stack.pop();
                if (c == ')' && next != '(') {
                    return false;
                }
                if (c == ']' && next != '[') {
                    return false;
                }
                if (c == '}' && next != '{') {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
