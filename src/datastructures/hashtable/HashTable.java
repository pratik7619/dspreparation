package datastructures.hashtable;

import java.util.ArrayList;

public class HashTable {

    private Node[] dataMap;

    HashTable() {
        int size = 7;
        dataMap = new Node[size];
    }

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + " ");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.print("{ " + temp.key + " = " + temp.value + " }");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    private int hash(String key) {
        int hash  = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    int getValue(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    Node get(String key) {
        int index = hash(key);
        Node requiredNode = dataMap[index];
        if (requiredNode == null) return null;
        Node temp = requiredNode;
        while (temp != null) {
            if (temp.key.equals(key)) {
                requiredNode = temp;
                break;
            }
            temp = temp.next;
        }
        return requiredNode;
    }

    ArrayList keys() {
        ArrayList<String> keys = new ArrayList<>();
        for (Node node : dataMap) {
            Node temp = node;
            while (temp != null) {
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }
}
