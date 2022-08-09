import java.io.*;
import java.util.*;

public class dfs {
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
        System.out.println(Arrays.toString(solve(0, adjList)));
        System.out.println(Arrays.toString(solve(1, adjList)));
    }

    public static int[] solve(int src, ArrayList<ArrayList<Integer>> adjList) {
        int[] visited = new int[adjList.size()];
        int[] parents = new int[adjList.size()];
        Arrays.fill(parents, -1);
        dfsUtil(src, adjList, visited, parents);
        return parents;
    }

    public static void dfsUtil(int src, ArrayList<ArrayList<Integer>> adjList, int[] visited, int[] parents) {
        for (int i = 0; i < adjList.get(src).size(); i++) {
            int next = adjList.get(src).get(i);
            if (visited[next] == 0) {
                visited[next] = 1;
                parents[next] = src;
                dfsUtil(next, adjList, visited, parents);
            }
        }
    }
}