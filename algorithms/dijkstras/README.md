# Dijkstras

- Single source shortest path algorithm
- Returns a shortest path tree from the source (dist, parent arrays)

## Algorithm

- Maintain two sets: the shortest path tree, and nodes not in the tree yet
- At each step, choose the minimum path node on the other side of the cut

## Time Complexity

- $O(V + E \cdot \log V)$ since we relax each edge once, with cost $\log V$ for updating the priority queue of nodes
- In theory, $\log (VE)$ due to implementation, but this is equivalent to $\log V$

## Notes

- In theory, maintain a distance for each node in priority queue, in practice, just add a new element to queue and skip out of date elements if polled (continue statement)
