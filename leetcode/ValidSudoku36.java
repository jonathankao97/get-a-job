import java.util.HashSet;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> horz = new HashSet<>();
            HashSet<Character> vert = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (horz.contains(board[i][j])) {
                        return false;
                    }
                    horz.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (vert.contains(board[j][i])) {
                        return false;
                    }
                    vert.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                HashSet<Character> seen = new HashSet<>();
                for (int k = 0; k < 9; k++) {
                    int x = i * 3 + k / 3;
                    int y = j * 3 + k % 3;
                    if (board[x][y] != '.') {
                        if (seen.contains(board[x][y])) {
                            return false;
                        }
                        seen.add(board[x][y]);
                    }
                }
            }
        }
        return true;
    }
}