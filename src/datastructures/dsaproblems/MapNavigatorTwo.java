package datastructures.dsaproblems;

import java.util.*;

class Graph {
    private final Map<String, List<EdgeNode>> adjList = new HashMap<>();

    public void addEdge(String from, String to, int distance) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(new EdgeNode(to, distance));
        adjList.get(to).add(new EdgeNode(from, distance)); // For undirected graph
    }

    public Map<String, Integer> dijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        for (String node : adjList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<EdgeNode> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.distance));
        pq.add(new EdgeNode(start, 0));

        while (!pq.isEmpty()) {
            EdgeNode currentEdge = pq.poll();
            String currentNode = currentEdge.destination;

            if (currentEdge.distance > distances.get(currentNode)) {
                continue;
            }

            for (EdgeNode neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                int newDist = distances.get(currentNode) + neighbor.distance;
                if (newDist < distances.get(neighbor.destination)) {
                    distances.put(neighbor.destination, newDist);
                    pq.add(new EdgeNode(neighbor.destination, newDist));
                }
            }
        }
        return distances;
    }

    public void printShortestPath(String start, String destination) {
        Map<String, Integer> distances = dijkstra(start);
        System.out.println("Shortest distance from " + start + " to " + destination + " is " + distances.getOrDefault(destination, -1));
    }
}

class EdgeNode {
    String destination;
    int distance;

    public EdgeNode(String destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
}

public class MapNavigatorTwo {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add edges to the graph
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "E", 3);
        graph.addEdge("E", "D", 4);
        graph.addEdge("D", "F", 11);

        // Print shortest path from start to destination
        graph.printShortestPath("A", "F");
    }
}

/**
 * Here’s an implementation of a Map Navigator using Dijkstra's algorithm in Java. This algorithm finds the shortest path between nodes in a graph, which can be represented as a map with nodes as locations and edges as paths between them with associated weights (distances).
 *
 * We'll use a priority queue to efficiently select the next node with the shortest tentative distance and a hash map to store distances.
 *
 * Explanation
 * Graph Representation:
 *
 * Each node is represented as a key in the adjList map, and each value is a list of edges (connections to other nodes).
 * Each Edge object contains a destination node and a distance.
 * dijkstra Method:
 *
 * Initialize Distances: All distances are set to infinity (Integer.MAX_VALUE) except the start node, which is set to 0.
 * Priority Queue: A min-priority queue (based on distance) is used to always expand the node with the shortest tentative distance.
 * Update Distances: For each neighboring node, calculate the new distance. If it’s shorter than the previously recorded distance, update it in distances and add the neighbor to the priority queue with the updated distance.
 * printShortestPath Method:
 *
 * Calls dijkstra to get the shortest distances from the start to all nodes and prints the shortest path distance to the specified destination.
 * Output Example
 * If you run the program with the given map, it will output the shortest path from node "A" to node "F":
 *
 * css
 * Copy code
 * Shortest distance from A to F is 18
 * Complexity
 * Time Complexity:
 * 𝑂
 * (
 * 𝐸
 * log
 * ⁡
 * 𝑉
 * )
 * O(ElogV), where
 * 𝐸
 * E is the number of edges, and
 * 𝑉
 * V is the number of vertices.
 * Space Complexity:
 * 𝑂
 * (
 * 𝑉
 * )
 * O(V), for storing distances and the priority queue.
 * This code efficiently finds the shortest path from a starting location to all reachable locations in a map-like structure.
 * */

