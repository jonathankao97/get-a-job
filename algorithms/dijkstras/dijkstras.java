import java.io.*;
import java.util.*;

public class dijkstras {

    public static class Pair implements Comparable<Pair> {
        public int key;
        public int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int compareTo(Pair that) {
            return Integer.compare(this.value, that.value);
        }
    }

    public static void main(String[] args) {
        ArrayList<Pair>[] adjList = new ArrayList[6];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        adjList[0].add(new Pair(1, 1));
        adjList[0].add(new Pair(2, 2));
        adjList[0].add(new Pair(3, 1));
        adjList[1].add(new Pair(0, 1));
        adjList[1].add(new Pair(2, 2));
        adjList[2].add(new Pair(4, 1));
        adjList[2].add(new Pair(5, 1));
        adjList[3].add(new Pair(2, 2));
        System.out.println(Arrays.toString(solve(adjList, 0)));
    }

    public static int[] solve(ArrayList<Pair>[] adjList, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[adjList.length];
        int[] parent = new int[adjList.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, Integer.MAX_VALUE);
        dist[src] = 0;
        parent[src] = -1;
        pq.add(new Pair(src, 0));
        while (pq.size() != 0) {
            Pair curr = pq.poll();
            int currNode = curr.key;
            int currDist = curr.value;
            if (currDist != dist[currNode]) {
                continue; // avoid relaxing nodes multiple times (due to pq implementation)
            }
            for (int i = 0; i < adjList[currNode].size(); i++) {
                Pair next = adjList[currNode].get(i);
                int nextNode = next.key;
                int nextDist = next.value;
                if (currDist + nextDist < dist[nextNode]) {
                    dist[nextNode] = currDist + nextDist;
                    parent[nextNode] = currNode;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }
        return dist;
    }
}