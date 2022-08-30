import java.io.*;
import java.util.*;

public class LetterCombinations17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String[]> mp = new HashMap<>();
        mp.put('1', new String[] {});
        mp.put('2', new String[] { "a", "b", "c" });
        mp.put('3', new String[] { "d", "e", "f" });
        mp.put('4', new String[] { "g", "h", "i" });
        mp.put('5', new String[] { "j", "k", "l" });
        mp.put('6', new String[] { "m", "n", "o" });
        mp.put('7', new String[] { "p", "q", "r", "s" });
        mp.put('8', new String[] { "t", "u", "v" });
        mp.put('9', new String[] { "w", "x", "y", "z" });
        return solve(digits, 0, mp, new ArrayList<>());
    }

    public List<String> solve(String digits, int idx, HashMap<Character, String[]> mp, List<String> partials) {
        if (idx == digits.length()) {
            return partials;
        }
        List<String> soln = new ArrayList<>();
        if (idx == 0) {
            partials.add("");
        }
        for (String partial : partials) {
            for (String digit : mp.get(digits.charAt(idx))) {
                soln.add(partial + digit);
            }
        }
        return solve(digits, idx + 1, mp, soln);
    }

}