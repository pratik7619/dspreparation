package datastructures.hashtable;

public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.set("print", 35);
        hashTable.set("nails", 800);
        hashTable.set("apple", 9);
        hashTable.set("pineapple", 90);
        hashTable.printTable();

        System.out.println(hashTable.get("nails").value);

        System.out.println(hashTable.keys());

    }
}
