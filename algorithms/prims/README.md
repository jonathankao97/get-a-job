# prims

-   Greedy Dijkstra's-like algorithm for finding a minimum spanning tree
-   The graph must be undirected with non-negative weights
-   Directed problem is NP-Hard

## Implementation Note

-   Recall that "safe edges" are the set of edges that minimally cross the cut for any partially optimal solution
-   Prim's starts with an optimal solution and builds larger optimal solutions by repeatedly choosing the minimum edge that crosses the cut
-   To do this, use a priority queue (custom comparator to make life easier) and add nodes and distances
-   In theory, should use key updates, but in practice easier to just throw into priority queue and check the visited array (don't explore twice)
-   In this case, must increment visited after dequeueing (not before enqueueing) since a better solution may be found while the solution is in the priority queue. (in general, this property only applies for priority queues since entries can "cut" each other, but not for generic queues)

## Complexity

-   $O(E \cdot \log(E))$ since for each edge, we add it to the priority queue a constant number of times, and the priority queue has at most $E$ size. In theory, we can reduce this to $O(E \cdot \log(V))$ with more clever queue management, but this is only better by a constant factor
