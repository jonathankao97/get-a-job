# prefix-sum

-   Simplest range query implementation with $O(n)$ pre-compute, $O(1)$ query, and $O(n)$ update
-   Similar concepts: segment trees, square root decomposition

## Implementation Notes

-   Lots of ways to implement this
-   Use $pfx$ of length $size + 1$, with 0 as the first element to follow inclusive, exclusive convention
-   Then, for a range query of $[2, 3]$, do $pfx[4] - pfx[2]$
-   For a range query of $[2, 4)$, do $pfx[4] - pfx[2]$
