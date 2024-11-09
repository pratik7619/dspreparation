package datastructures.dsaproblems;

import java.util.*;

class GraphNode {
    String name;
    List<Edge> edges;

    GraphNode(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }
}

class Edge {
    GraphNode target;
    int weight;

    Edge(GraphNode target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class MapNavigatorOne {
    private final Map<String, GraphNode> nodes;

    public MapNavigatorOne() {
        nodes = new HashMap<>();
    }

    public void addLocation(String name) {
        nodes.put(name, new GraphNode(name));
    }

    public void addRoute(String from, String to, int distance) {
        GraphNode sourceNode = nodes.get(from);
        GraphNode targetNode = nodes.get(to);
        if (sourceNode != null && targetNode != null) {
            sourceNode.edges.add(new Edge(targetNode, distance));
            targetNode.edges.add(new Edge(sourceNode, distance)); // Assuming undirected graph
        }
    }

    public List<String> findShortestPath(String start, String end) {
        if (!nodes.containsKey(start) || !nodes.containsKey(end)) {
            return Collections.emptyList();
        }

        Map<GraphNode, Integer> distances = new HashMap<>();
        Map<GraphNode, GraphNode> previous = new HashMap<>();
        PriorityQueue<GraphNode> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (GraphNode node : nodes.values()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(nodes.get(start), 0);
        pq.add(nodes.get(start));

        while (!pq.isEmpty()) {
            GraphNode currentNode = pq.poll();

            if (currentNode.name.equals(end)) {
                return reconstructPath(previous, nodes.get(start), nodes.get(end));
            }

            for (Edge edge : currentNode.edges) {
                GraphNode neighbor = edge.target;
                int newDist = distances.get(currentNode) + edge.weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, currentNode);
                    pq.add(neighbor);
                }
            }
        }

        return Collections.emptyList(); // No path found
    }

    private List<String> reconstructPath(Map<GraphNode, GraphNode> previous, GraphNode start, GraphNode end) {
        List<String> path = new LinkedList<>();
        for (GraphNode at = end; at != null; at = previous.get(at)) {
            path.add(0, at.name);
        }
        return path.get(0).equals(start.name) ? path : Collections.emptyList();
    }

    public static void main(String[] args) {
        MapNavigatorOne navigator = new MapNavigatorOne();

        // Adding locations
        navigator.addLocation("A");
        navigator.addLocation("B");
        navigator.addLocation("C");
        navigator.addLocation("D");
        navigator.addLocation("E");

        // Adding routes with distances
        navigator.addRoute("A", "B", 4);
        navigator.addRoute("A", "C", 2);
        navigator.addRoute("B", "C", 5);
        navigator.addRoute("B", "D", 10);
        navigator.addRoute("C", "D", 3);
        navigator.addRoute("D", "E", 4);
        navigator.addRoute("C", "E", 9);

        // Finding shortest path
        List<String> shortestPath = navigator.findShortestPath("A", "E");
        System.out.println("Shortest path from A to E: " + shortestPath);
    }
}

/**
 * Dijkstra's algorithm is widely used for finding the shortest path between nodes in a weighted graph. Below is an implementation in Java for a MapNavigator class that finds the shortest path between two nodes (representing locations) using Dijkstra's algorithm.
 *
 * Explanation
 * Graph Representation:
 *
 * Each location is represented as a GraphNode, which has a name and a list of Edge objects connecting it to neighboring nodes.
 * An Edge has a target node and a weight representing the distance.
 * Adding Locations and Routes:
 *
 * addLocation(String name): Adds a location by creating a new GraphNode.
 * addRoute(String from, String to, int distance): Adds a bi-directional edge between two locations with a specified distance.
 * Dijkstra's Algorithm (findShortestPath):
 *
 * Initializes distances to all nodes as infinity, except the start node, which is set to zero.
 * Uses a priority queue to explore the node with the smallest tentative distance.
 * For each neighboring node, it calculates the distance through the current node and updates if it’s smaller than the known distance.
 * Path Reconstruction (reconstructPath):
 *
 * Builds the path from the end node back to the start using the previous map.
 * Output:
 *
 * The program will print the shortest path from location "A" to "E".
 * Example Output
 * Given the routes and distances:
 *
 * mathematica
 * Copy code
 * Shortest path from A to E: [A, C, D, E]
 * Complexity
 * Time Complexity:
 * 𝑂
 * (
 * (
 * 𝑉
 * +
 * 𝐸
 * )
 * log
 * ⁡
 * 𝑉
 * )
 * O((V+E)logV), where
 * 𝑉
 * V is the number of nodes and
 * 𝐸
 * E is the number of edges, due to the priority queue operations.
 * Space Complexity:
 * 𝑂
 * (
 * 𝑉
 * +
 * 𝐸
 * )
 * O(V+E), for storing distances, the priority queue, and adjacency lists.
 * This solution is efficient for finding the shortest paths on a map with multiple locations and routes.
 * */
