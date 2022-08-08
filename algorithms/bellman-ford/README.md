# Bellman-Ford

-   Single source shortest path algorithm, allows negative weight edges
-   Returns a shortest path tree from the source (dist, parent arrays)
-   Detects if there is a negative weight cycle

## Algorithm

-   Uses fact that a shortest path in a graph with no negative weight cycles has length at most $V - 1$
-   Can be viewed as a DP algorithm where after pass $i$, we know that all shortest paths of length $i$ from the source have been discovered
-   To detect if a negative weight cycle exists, check if a relaxation occurs on step $V$, which should not occur

## Time Complexity

-   Simply $O(VE)$ since we relax each edge $V$ times
