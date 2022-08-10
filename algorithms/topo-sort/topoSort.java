import java.io.*;
import java.util.*;

public class topoSort {

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
        adjList.get(4).add(5);
        System.out.println(Arrays.toString(topoSortBfs(adjList)));
        System.out.println(Arrays.toString(topoSortDfs(adjList)));
    }

    public static int[] topoSortBfs(ArrayList<ArrayList<Integer>> adjList) {
        int[] in = new int[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                int v = adjList.get(i).get(j);
                in[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[adjList.size()];
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                q.add(i);
                visited[i] = 1;
            }
        }
        int[] soln = new int[adjList.size()];
        int solnIdx = 0;
        while (q.size() != 0) {
            int curr = q.poll();
            soln[solnIdx++] = curr;
            for (int neighbor : adjList.get(curr)) {
                if (--in[neighbor] == 0 && visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    q.add(neighbor);
                }
            }
        }
        return soln;
    }

    public static int[] topoSortDfs(ArrayList<ArrayList<Integer>> adjList) {
        int[] visited = new int[adjList.size()];
        Stack<Integer> soln = new Stack<>();
        visited[0] = 1;
        topoSortDfsUtil(adjList, soln, 0, visited);
        int[] ans = new int[adjList.size()];
        int ansIdx = 0;
        while (soln.size() != 0) {
            ans[ansIdx++] = soln.pop();
        }
        return ans;
    }

    public static void topoSortDfsUtil(ArrayList<ArrayList<Integer>> adjList, Stack<Integer> soln, int src,
            int[] visited) {
        for (int neighbor : adjList.get(src)) {
            if (visited[neighbor] == 0) {
                visited[neighbor] = 1;
                topoSortDfsUtil(adjList, soln, neighbor, visited);
            }
        }
        soln.add(src);
    }
}