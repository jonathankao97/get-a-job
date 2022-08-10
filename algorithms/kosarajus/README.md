# kosarajus

-   Linear time algorithm to find the strongly connected components of a directed graph
-   Simpler than Tarjan's algorithm

## Implementation

-   Run DFS on $G$
-   Run DFS on $G^R$, considering root nodes in decreasing order of finish time
-   Each DFS forest is a strongly connected component
-   From a practical perspective, instead of dealing with in, out, and time, just add the nodes into a stack (this will output in reverse finish time when popped)

## Why does this work

-   Observe that SCCs don't change between $G$ and $G^R$ and by processing (b) in decreasing finish time of the result of (a), we never allow each DFS forest to "escape" the SCC of the previous forest
