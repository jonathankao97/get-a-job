import java.io.*;
import java.util.*;

public class bellmanFord {

    public static class Pair {
        public int key;
        public int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ArrayList<Pair>[] adjList = new ArrayList[6];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        adjList[0].add(new Pair(1, 2));
        adjList[0].add(new Pair(2, 1));
        adjList[0].add(new Pair(3, 1));
        adjList[1].add(new Pair(2, -2));
        adjList[2].add(new Pair(4, 1));
        adjList[2].add(new Pair(5, 1));
        adjList[3].add(new Pair(2, 2));
        adjList[4].add(new Pair(5, -3));
        System.out.println(Arrays.toString(solve(adjList, 0)));

        adjList[2].add(new Pair(0, -1));
        int[] soln = solve(adjList, 0);
        if (soln == null) {
            System.out.println("negative weight cycle discovered");
        } else {
            System.out.println(Arrays.toString(soln));
        }
    }

    public static int[] solve(ArrayList<Pair>[] adjList, int src) {
        int[] dist = new int[adjList.length];
        int[] parent = new int[adjList.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, Integer.MAX_VALUE);
        dist[src] = 0;
        parent[src] = -1;
        for (int i = 0; i < adjList.length - 1; i++) {
            for (int j = 0; j < adjList.length; j++) {
                for (int k = 0; k < adjList[j].size(); k++) {
                    Pair next = adjList[j].get(k);
                    int nextNode = next.key;
                    int nextDist = next.value;
                    if (dist[j] != Integer.MAX_VALUE && dist[j] + nextDist < dist[nextNode]) {
                        dist[nextNode] = dist[j] + nextDist;
                        parent[nextNode] = j;
                    }
                }
            }
        }

        // check for negative weight cycles
        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                Pair next = adjList[i].get(j);
                int nextNode = next.key;
                int nextDist = next.value;
                if (dist[i] != Integer.MAX_VALUE && dist[i] + nextDist < dist[nextNode]) {
                    return null;
                }
            }
        }

        return dist;
    }
}
