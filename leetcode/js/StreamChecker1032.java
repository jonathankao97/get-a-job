import java.io.*;
import java.util.*;

public class StreamChecker1032 {

    public class Node {
        boolean finish;
        Node[] children;

        public Node() {
            this.finish = false;
            this.children = new Node[26];
        }

        public void insert(String word) {
            if (word.length() == 0) {
                this.finish = true;
                return;
            }
            int idx = word.charAt(0) - 'a';
            if (this.children[idx] == null) {
                this.children[idx] = new Node();
            }
            this.children[idx].insert(word.substring(1));
        }

        public boolean solve(String word) {
            if (this.finish) {
                return true;
            } else if (word.length() == 0) {
                return false;
            } else {
                int idx = word.charAt(0) - 'a';
                if (this.children[idx] == null) {
                    return false;
                } else {
                    return this.children[idx].solve(word.substring(1));
                }
            }
        }
    }

    public Node trie;
    public String str;

    public StreamChecker1032(String[] words) {
        this.trie = new Node();
        for (String word : words) {
            StringBuilder builder = new StringBuilder(word);
            this.trie.insert(builder.reverse().toString());
        }
    }

    public boolean query(char letter) {
        this.str = letter + this.str;
        return this.trie.solve(str);
    }
}