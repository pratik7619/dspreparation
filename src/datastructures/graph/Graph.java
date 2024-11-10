package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Graph {

    Random random = new Random();
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    void printGraph() {
        System.out.println(adjList);
    }

    boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null) return false;
        for (String otherVertex : adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

    void put(String key, String value) {
        if (adjList.containsKey(key)) {
            ArrayList<String> values = adjList.get(key);
            values.add(value);
            adjList.put(key, values);
        } else {
            adjList.put(key, new ArrayList<>());
        }
    }

    String getAndRandomRemove(String key) {
        if (adjList.containsKey(key)) {
            ArrayList<String> values = adjList.get(key);
            if (!values.isEmpty()) {
                return values.remove(random.nextInt(values.size()));
            }
        }
        return null;
    }
}
