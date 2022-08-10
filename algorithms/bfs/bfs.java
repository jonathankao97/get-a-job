import java.io.*;
import java.util.*;

public class bfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(0).add(3);
        adjList.get(1).add(2);
        adjList.get(2).add(4);
        adjList.get(2).add(5);
        adjList.get(3).add(2);
        System.out.println(Arrays.toString(solve(adjList, 0)));
        System.out.println(Arrays.toString(solve(adjList, 1)));
    }

    public static int[] solve(ArrayList<ArrayList<Integer>> adjList, int src) {
        int[] visited = new int[adjList.size()];
        int[] parent = new int[adjList.size()];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = 1;
        while (q.size() != 0) {
            int curr = q.poll();
            for (int neighbor : adjList.get(curr)) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    parent[neighbor] = curr;
                    q.add(neighbor);
                }
            }
        }
        return parent;
    }
}