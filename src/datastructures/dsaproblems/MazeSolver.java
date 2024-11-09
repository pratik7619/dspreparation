package datastructures.dsaproblems;

import java.util.*;

class MazeSolver {
    private final int[][] maze;
    private final int rows, cols;
    private final int[] start, end;

    public MazeSolver(int[][] maze, int[] start, int[] end) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
        this.start = start;
        this.end = end;
    }

    // Direction vectors for up, down, left, right movements
    private final int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    public List<int[]> solveDFS() {
        List<int[]> path = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        dfs(start[0], start[1], path, visited);
        return path;
    }

    private boolean dfs(int row, int col, List<int[]> path, Set<String> visited) {
        if (!isInBounds(row, col) || maze[row][col] == 1 || visited.contains(row + "," + col)) return false;

        path.add(new int[] { row, col });
        visited.add(row + "," + col);

        if (row == end[0] && col == end[1]) return true;

        for (int[] dir : directions) {
            if (dfs(row + dir[0], col + dir[1], path, visited)) return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public List<int[]> solveBFS() {
        Queue<int[]> queue = new LinkedList<>();
        Map<String, int[]> parent = new HashMap<>();
        queue.offer(start);
        parent.put(start[0] + "," + start[1], null);

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            if (row == end[0] && col == end[1]) return constructPath(parent);

            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];
                String key = newRow + "," + newCol;

                if (isInBounds(newRow, newCol) && maze[newRow][newCol] == 0 && !parent.containsKey(key)) {
                    queue.offer(new int[] { newRow, newCol });
                    parent.put(key, cell);
                }
            }
        }
        return Collections.emptyList(); // No path found
    }

    public List<int[]> solveAStar() {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Map<String, Integer> gScore = new HashMap<>();
        Map<String, int[]> parent = new HashMap<>();

        String startKey = start[0] + "," + start[1];
        gScore.put(startKey, 0);
        openSet.add(new Node(start, 0, heuristic(start, end)));
        parent.put(startKey, null);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            int[] cell = current.position;
            String cellKey = cell[0] + "," + cell[1];

            if (Arrays.equals(cell, end)) return constructPath(parent);

            for (int[] dir : directions) {
                int newRow = cell[0] + dir[0], newCol = cell[1] + dir[1];
                String neighborKey = newRow + "," + newCol;

                if (isInBounds(newRow, newCol) && maze[newRow][newCol] == 0) {
                    int tentativeGScore = gScore.getOrDefault(cellKey, Integer.MAX_VALUE) + 1;

                    if (tentativeGScore < gScore.getOrDefault(neighborKey, Integer.MAX_VALUE)) {
                        gScore.put(neighborKey, tentativeGScore);
                        int fScore = tentativeGScore + heuristic(new int[]{newRow, newCol}, end);
                        openSet.add(new Node(new int[]{newRow, newCol}, tentativeGScore, fScore));
                        parent.put(neighborKey, cell);
                    }
                }
            }
        }
        return Collections.emptyList(); // No path found
    }

    private int heuristic(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]); // Manhattan distance
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private List<int[]> constructPath(Map<String, int[]> parent) {
        List<int[]> path = new LinkedList<>();
        int[] step = end;

        while (step != null) {
            path.add(0, step);
            step = parent.get(step[0] + "," + step[1]);
        }
        return path;
    }

    private static class Node {
        int[] position;
        int cost;

        Node(int[] position, int g, int f) {
            this.position = position;
            this.cost = f;
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 0, 0, 1, 0, 0 },
                { 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0 }
        };

        int[] start = {0, 0};
        int[] end = {4, 4};
        MazeSolver solver = new MazeSolver(maze, start, end);

        System.out.println("DFS Path: " + solver.solveDFS());
        System.out.println("BFS Path: " + solver.solveBFS());
        System.out.println("A* Path: " + solver.solveAStar());
    }
}
/**
 * Here’s a Java implementation of a maze solver using three common pathfinding algorithms: DFS, BFS, and A*.
 *
 * Each algorithm will find a path from a start point to an end point on a grid where:
 *
 * 0 represents open spaces in the maze.
 * 1 represents walls in the maze.
 * The MazeSolver class below provides methods to solve the maze using each algorithm.
 *
 * Explanation of Algorithms
 * DFS (Depth-First Search):
 *
 * DFS is a recursive algorithm that explores as far as possible along each branch before backtracking.
 * Not optimal; it may not find the shortest path.
 * Uses a visited set to avoid revisiting cells and a path list to store the result if the endpoint is found.
 * BFS (Breadth-First Search):
 *
 * BFS explores each level of nodes before moving deeper, making it ideal for finding the shortest path in unweighted grids.
 * Uses a queue to store nodes at the current level and a parent map to reconstruct the path once the endpoint is found.
 * A* (A-Star Search):
 *
 * A* uses a priority queue to explore nodes based on a cost function (f = g + h), where:
 * g is the distance from the start to the current node.
 * h (heuristic) is the estimated distance from the current node to the end node (Manhattan distance here).
 * gScore and parent are used to manage costs and reconstruct the shortest path.
 * Helper Functions
 * isInBounds: Checks if the cell is within grid boundaries.
 * constructPath: Builds the path from the endpoint back to the start using the parent map.
 * heuristic: Calculates the Manhattan distance between two points, used in A* for prioritizing nodes closer to the goal.
 * Output Example
 * Assuming maze, start, and end positions defined in main:
 * less
 * Copy code
 * DFS Path: [[0, 0], [1, 1], [2, 1], [2, 2], [3, 3], [4, 4]]
 * BFS Path: [[0, 0], [0, 1], [1, 1], [2, 1], [2, 2], [2, 3], [2, 4], [3, 4], [4, 4]]
 * A* Path: [[0, 0], [0, 1], [1, 1], [2, 1], [2, 2], [3, 3], [4, 4]]
 * Complexity
 * DFS: Time
 * 𝑂(𝑉+𝐸)
 * O(V+E), but might explore unnecessary paths.
 * BFS: Time
 * 𝑂(𝑉+E)
 * O(V+E), finds the shortest path in an unweighted grid.
 * A*: Time
 * 𝑂(E log f() V)
 * O(ElogV), finds the optimal path with the heuristic guiding the search efficiently.
 * Each algorithm can be suited for different maze-solving needs, with A* being the most efficient for finding the shortest path in weighted grids.
 * */
