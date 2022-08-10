# dfs

- Depth first graph traversal algorithm
- Returns DFS forest in the form of arrival and departure array

## Time Complexity

- $O(V+E)$

## Notes

- Solve recursively, make helper function that takes in time, visited, arrival, and departure arrays
- Helper function should return time

## Well known applications

- Checking if an undirected graph is connected by counting the number of trees
- Checking if a directed graph is strongly connected by running DFS on $G, G^R$
- Testing for cycles in both directed and undirected graphs by checking if there are any back edges by checking start and end times

## Adjacent Applications

- Topological sorting by returning nodes in reverse finish time
- Finding strongly connected components (Kosaraju's) by first doing a DFS on $G$, then a DFS on $G^R$, considering vertices in decreasing order of finish time and then returning each DFS tree as a strongly connected component
