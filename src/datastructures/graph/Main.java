package datastructures.graph;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.printGraph(); // {A=[], B=[], C=[]}

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.printGraph(); // {A=[B, C, D], B=[A, D], C=[A, D], D=[A, B, C]}

//        graph.removeEdge("A", "B");
//        graph.printGraph(); // {A=[C], B=[C], C=[A, B]}

        graph.removeVertex("D");
        graph.printGraph(); // {A=[B, C], B=[A], C=[A]}
    }
}
