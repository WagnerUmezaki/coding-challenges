# Remove islands

Credit: https://www.youtube.com/watch?v=4tYoVx0QoN0

Given a binary integer 2d array, filled with 0's and 1's. Remove all 1's that not connects to the border. 1's that connects to the the border through another 1's are valid.

Connection is considered only on horizontal and vertical tuples.

Example 

input
```
[
    [1, 0, 0, 0, 0, 0],
    [0, 1, 0, 1, 1, 1],
    [0, 0, 1, 0, 1, 0],
    [1, 1, 0, 0, 1, 0],
    [1, 0, 1, 1, 0, 0],
    [1, 0, 0, 0, 0, 1]
]
```
output
```
[
    [1, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 1, 1],
    [0, 0, 0, 0, 1, 0],
    [1, 1, 0, 0, 1, 0],
    [1, 0, 0, 0, 0, 0],
    [1, 0, 0, 0, 0, 1]
]
```