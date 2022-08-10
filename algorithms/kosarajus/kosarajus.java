import java.io.*;
import java.util.*;

public class kosarajus {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(2);
        adjList.get(0).add(3);
        adjList.get(1).add(0);
        adjList.get(2).add(1);
        adjList.get(3).add(4);
        adjList.get(4).add(5);
        adjList.get(5).add(4);
        System.out.println(solve(adjList));
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> adjList) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[adjList.size()];
        dfsUtil(adjList, stack, 0, visited);

        ArrayList<ArrayList<Integer>> reverseAdjList = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            reverseAdjList.add(new ArrayList<>());
        }
        for (int i = 0; i < adjList.size(); i++) {
            for (int j : adjList.get(i)) {
                reverseAdjList.get(j).add(i);
            }
        }

        ArrayList<ArrayList<Integer>> soln = new ArrayList<>();
        int[] reverseVisited = new int[adjList.size()];
        while (stack.size() != 0) {
            int root = stack.pop();
            if (reverseVisited[root] == 0) {
                Stack<Integer> scc = new Stack<>();
                reverseVisited[root] = 1;
                dfsUtil(reverseAdjList, scc, root, reverseVisited);
                soln.add(new ArrayList<>(scc));
            }
        }
        return soln;
    }

    public static void dfsUtil(ArrayList<ArrayList<Integer>> adjList, Stack<Integer> stack, int src, int[] visited) {
        for (int neighbor : adjList.get(src)) {
            if (visited[neighbor] == 0) {
                visited[neighbor] = 1;
                dfsUtil(adjList, stack, neighbor, visited);
            }
        }
        stack.push(src);
    }

}