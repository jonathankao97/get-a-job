import java.io.*;
import java.util.*;

public class RobotSim874 {

    public static int robotSim(int[] commands, int[][] obstacles) {
        HashSet<List<Integer>> hs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(obstacle[0]);
            list.add(obstacle[1]);
            hs.add(list);
        }
        int[][] cards = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[] pos = { 0, 0 };
        int dir = 0;
        int max = 0;
        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                dir = (dir + 3) % 4;
            } else {
                int[] card = cards[dir];
                for (int i = 0; i < command; i++) {
                    int nextX = pos[0] + card[0];
                    int nextY = pos[1] + card[1];
                    ArrayList<Integer> next = new ArrayList<>();
                    next.add(nextX);
                    next.add(nextY);
                    if (hs.contains(next)) {
                        break;
                    } else {
                        pos[0] = nextX;
                        pos[1] = nextY;
                        max = Math.max(max, pos[0] * pos[0] + pos[1] * pos[1]);
                    }
                }
            }
        }
        return max;
    }

}