# topo-sort

- Basic application of BFS, DFS, outputs a DAG ordering
- In a directed graph, if there are no cycles, a DAG ordering always exists
- $O(V+E)$

## BFS Implementation

- Otherwise known as Kahn's algorithm, easiest to understand intuitively
- Simply compute in degree for each node, and run BFS starting with all nodes of in degree 0
- Update in degree as needed

## DFS Implementation

- In theory, return nodes in reverse order of finish time
- This can be done with typical DFS implementation keeping track of in, out, and time
- In practice, much easier to keep a pointer to stack and add to stack when done
