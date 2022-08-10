# bfs

-   Breadth first search traversal algorithm
-   Returns parent array

## Time Complexity

-   $O(V+E)$

## Notes

-   Use visited, parent array, queue
-   Remember to be consistent with visiting (either always visit before enqueueing, or always visit after)

## Well Known Applications

-   Checking if an undirected graph $G$ is connected trivially
-   Checking for cycles in undirected graphs by checking visited array for revisits
-   Checking for cycles in directed graphs by using the same idea as Kahn's algorithm (if number of nodes with in-degree 0 at the end of the algorithm is not all the nodes, there are some nodes part of a cycle)
-   Checking if a directed graph $G$ is strongly connected by running BFS on $G, G^R$
-   Computing unweighted single source shortest paths
-   Computing connected components
