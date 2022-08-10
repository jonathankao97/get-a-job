# kruskals

-   Uses a different approach than prims: among all safe edges, choose the one with the minimum weight
-   Uses a DSU: supports find operations in $O(1)$ and merge operations in $O(\log n)$

## Implementation Basic Steps

-   Initialize DSU to have all nodes be own set
-   Sort edges
-   Process edges one at a time, merging nodes if part of different set
-   Recall that implementing Dsu requires two underlying arrays (Dsu, Size), with smart updates to Dsu for merge, find (recursive)

## Time Complexity

-   Sorting Edges $O(E \log E)$
-   Merging Dsu $O(V \log V)$ by amortized analysis (since after every merge, size must at least double)
