import java.io.*;
import java.util.*;

public class kruskals {
    public static class Dsu {
        int[] dsu, sizes;

        public Dsu(int n) {
            this.dsu = new int[n];
            this.sizes = new int[n];
            Arrays.fill(this.dsu, -1);
            Arrays.fill(this.sizes, 1);
        }

        public int find(int a) {
            if (this.dsu[a] == -1 || this.dsu[a] == a) {
                return a;
            }
            this.dsu[a] = find(this.dsu[a]);
            return this.dsu[a];
        }

        public void merge(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (this.sizes[pa] >= this.sizes[pb]) {
                this.dsu[pb] = pa;
                this.sizes[pa] += this.sizes[pb];
            } else {
                this.dsu[pa] = pb;
                this.sizes[pb] += this.sizes[pa];
            }
        }
    }

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
        System.out.println(solve(adjList));
    }

    public static int solve(ArrayList<ArrayList<int[]>> adjList) {
        Dsu dsu = new Dsu(adjList.size());
        ArrayList<int[]> edges = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            for (int[] neighbor : adjList.get(i)) {
                edges.add(new int[] { i, neighbor[0], neighbor[1] });
            }
        }
        Comparator<int[]> comparator = new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        };
        Collections.sort(edges, comparator);
        int cost = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (dsu.find(u) != dsu.find(v)) {
                cost += edge[2];
                dsu.merge(u, v);
            }
        }
        return cost;
    }
}