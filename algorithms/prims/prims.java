import java.io.*;
import java.util.*;

public class prims {

    public static void main(String[] args) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(new int[] { 1, 1 });
        adjList.get(0).add(new int[] { 3, 4 });
        adjList.get(1).add(new int[] { 0, 1 });
        adjList.get(1).add(new int[] { 3, 3 });
        adjList.get(1).add(new int[] { 2, 2 });
        adjList.get(2).add(new int[] { 1, 2 });
        adjList.get(2).add(new int[] { 4, 6 });
        adjList.get(3).add(new int[] { 0, 4 });
        adjList.get(3).add(new int[] { 1, 3 });
        adjList.get(3).add(new int[] { 4, 5 });
        adjList.get(4).add(new int[] { 2, 6 });
        adjList.get(4).add(new int[] { 3, 5 });
        adjList.get(4).add(new int[] { 5, 7 });
        adjList.get(5).add(new int[] { 4, 7 });
        adjList.get(5).add(new int[] { 3, 8 });
        for (int i = 0; i < 6; i++) {
            System.out.println("Src: " + i + " Cost: " + solve(adjList, i));
        }
    }

    public static int solve(ArrayList<ArrayList<int[]>> adjList, int src) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        int[] visited = new int[adjList.size()];
        int cost = 0;
        pq.add(new int[] { src, 0 });
        while (pq.size() != 0) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            if (visited[currNode] == 1) {
                continue;
            }
            visited[currNode] = 1;
            cost += curr[1];
            for (int[] neighbor : adjList.get(currNode)) {
                int neighborNode = neighbor[0];
                int neighborCost = neighbor[1];
                if (visited[neighborNode] == 0) {
                    pq.add(new int[] { neighborNode, neighborCost });
                }
            }
        }
        return cost;
    }
}