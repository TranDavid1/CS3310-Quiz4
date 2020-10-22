"CS3310-Quiz4"

Implementation is done in Java.

Requirements: Latest version of Java.

Problem 1:
Given an array of integers, sort the array into an alternating sequence of peaks and valleys.

Solution:
1. Traverse all even numbered elements in the given input array
2. If current element is smaller than the previous odd element, swap the two elements
3. If current element is smaller than the next odd element, swap the two elements
This is done in O(n) time because the algorithm only does a single traversal of the given array.

Example of execution of the program:

![Image1](https://i.gyazo.com/577b23337828b3c9bfbe8ff0824a6bf5.png)

Problem 2: 
Given a list of projects and dependencies, output a build order that will allow the projects to be built:

Solution:
1. Initialize a queue to keep track of all nodes with 0 in-degree
2. Iterate over all edges in the input and create an adjacency list, as well as a map of node vs in-degree
3. Add all the nodes with 0 in-degree to the queue
4. Repeat the following steps until the queue is empty
5. Pop a node from the queue, let's call this node N
6. For all neighbors of N, reduce their in-degree by 1. If any of these nodes reach 0 in-degree, add it to the queue
7. Add the node N to the list, while maintaining topological sort

Example of execution of the program:

![Image 2](https://i.gyazo.com/9512048d62b03c1f769c24eec43eaf23.png)
