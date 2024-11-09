package datastructures.dsaproblems;

import java.util.*;

class TravelPlanner {
    private final Map<String, List<Edge>> graph;

    public TravelPlanner() {
        graph = new HashMap<>();
    }

    public void addCity(String city) {
        graph.putIfAbsent(city, new ArrayList<>());
    }

    public void addRoute(String city1, String city2, int travelTime) {
        graph.get(city1).add(new Edge(city2, travelTime));
        graph.get(city2).add(new Edge(city1, travelTime)); // Undirected graph
    }

    public List<String> findShortestPath(String start, String end) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.travelTime));
        Map<String, Integer> travelTime = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for (String city : graph.keySet()) {
            travelTime.put(city, Integer.MAX_VALUE);
        }
        travelTime.put(start, 0);
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String currentCity = current.city;

            if (currentCity.equals(end)) break;

            for (Edge edge : graph.getOrDefault(currentCity, new ArrayList<>())) {
                int newTime = travelTime.get(currentCity) + edge.travelTime;

                if (newTime < travelTime.get(edge.destination)) {
                    travelTime.put(edge.destination, newTime);
                    parent.put(edge.destination, currentCity);
                    queue.add(new Node(edge.destination, newTime));
                }
            }
        }

        return constructPath(parent, start, end);
    }

    private List<String> constructPath(Map<String, String> parent, String start, String end) {
        LinkedList<String> path = new LinkedList<>();
        String step = end;

        while (step != null) {
            path.addFirst(step);
            step = parent.get(step);
        }

        return path.isEmpty() || !path.getFirst().equals(start) ? Collections.emptyList() : path;
    }

    public void printRoutes() {
        for (Map.Entry<String, List<Edge>> entry : graph.entrySet()) {
            String city = entry.getKey();
            System.out.println("From " + city + ":");
            for (Edge edge : entry.getValue()) {
                System.out.println("  - To " + edge.destination + " in " + edge.travelTime + " mins");
            }
        }
    }

    private static class Edge {
        String destination;
        int travelTime;

        Edge(String destination, int travelTime) {
            this.destination = destination;
            this.travelTime = travelTime;
        }
    }

    private static class Node {
        String city;
        int travelTime;

        Node(String city, int travelTime) {
            this.city = city;
            this.travelTime = travelTime;
        }
    }

    public static void main(String[] args) {
        TravelPlanner planner = new TravelPlanner();

        // Add cities
        planner.addCity("New York");
        planner.addCity("Los Angeles");
        planner.addCity("Chicago");
        planner.addCity("Houston");
        planner.addCity("Miami");

        // Add routes (times in minutes)
        planner.addRoute("New York", "Chicago", 180);
        planner.addRoute("Chicago", "Los Angeles", 240);
        planner.addRoute("Los Angeles", "Houston", 180);
        planner.addRoute("Houston", "Miami", 150);
        planner.addRoute("New York", "Miami", 210);

        planner.printRoutes();

        // Find shortest path
        String startCity = "New York";
        String endCity = "Los Angeles";
        System.out.println("\nShortest path from " + startCity + " to " + endCity + ":");
        List<String> path = planner.findShortestPath(startCity, endCity);
        if (path.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println(String.join(" -> ", path));
        }
    }
}

/*
* A travel planner application using graphs can help find optimal routes, suggest places of interest, and calculate travel times. In this Java implementation, cities are nodes, and paths between them are edges. This graph-based planner will help you find the shortest or most efficient routes between cities using Dijkstra’s algorithm.

Graph Structure and Implementation
Nodes (Vertices): Represent cities.
Edges: Represent connections (roads, flights) between cities with weights as travel time or cost.
Algorithms: Dijkstra’s for finding the shortest path between cities.
Here’s a basic structure of a TravelPlanner using a weighted, undirected graph.
*
* Explanation of Key Components
Graph Representation:

Map<String, List<Edge>> graph: Represents each city and its edges (connections to other cities).
Each Edge has a destination city and travel time.
Adding Cities and Routes:

addCity(String city): Adds a city node.
addRoute(String city1, String city2, int travelTime): Adds a route between two cities with the given travel time, creating an undirected connection.
Dijkstra’s Algorithm for Shortest Path:

Uses a priority queue to store cities based on their shortest known travel time.
The algorithm updates the shortest known travel time to each city as it explores the graph.
Path Construction:

Once the shortest path is determined, the constructPath method backtracks from the destination to the start using the parent map.
printRoutes Method:

Lists all routes from each city, showing the destinations and travel times.
Sample Output
If you run this code, you will see a list of cities, routes, and the shortest path between New York and Los Angeles:

vbnet
Copy code
From New York:
  - To Chicago in 180 mins
  - To Miami in 210 mins
From Los Angeles:
  - To Chicago in 240 mins
  - To Houston in 180 mins
From Chicago:
  - To New York in 180 mins
  - To Los Angeles in 240 mins
From Houston:
  - To Los Angeles in 180 mins
  - To Miami in 150 mins
From Miami:
  - To Houston in 150 mins
  - To New York in 210 mins

Shortest path from New York to Los Angeles:
New York -> Chicago -> Los Angeles
Complexity Analysis
Time Complexity:
𝑂((𝑉+𝐸)log⁡𝑉)
O((V+E)logV), where 𝑉
V is the number of cities and 𝐸, E is the number of routes. The priority queue operations and edge relaxations dominate the complexity.
Space Complexity: 𝑂(𝑉+𝐸)
O(V+E), as the algorithm stores distances and paths for each node and edge.
Potential Enhancements
Multiple Criteria: You could extend this implementation to handle multiple criteria (like cost and time) using a custom comparison function.
A* Search: Use A* if you need faster performance and have an estimated distance heuristic between cities (like the geographical distance).
Graphical Interface: Connect this code with a GUI or web application for interactive route planning and visualization.
* */

