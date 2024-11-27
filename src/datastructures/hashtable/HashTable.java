package datastructures.hashtable;

import java.util.*;

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

    public static ArrayList<Integer> findDuplicates(int[] nums) {

        // Create a new HashMap to store the count of occurrences
        // of each integer.
        Map<Integer, Integer> numCounts = new HashMap<>();

        // Loop through each integer in the input array and update
        // its count in the HashMap.
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }

        // Create a new ArrayList to store the duplicate integers.
        ArrayList<Integer> duplicates = new ArrayList<>();

        // Loop through each entry in the HashMap and check if the
        // count of occurrences is greater than 1.
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        // Return the ArrayList of duplicate integers.
        return duplicates;
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        // Create a map to store anagram groups
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Iterate over each string in the input array
        for (String string : strings) {
            // Convert the string to a char array
            char[] chars = string.toCharArray();
            // Sort the char array
            Arrays.sort(chars);
            // Create a canonical string from sorted chars
            String canonical = new String(chars);

            // Check if the map contains the canonical key
            if (anagramGroups.containsKey(canonical)) {
                // Add the string to the existing group
                anagramGroups.get(canonical).add(string);
            } else {
                // Create a new group for the string
                List<String> group = new ArrayList<>();
                group.add(string);
                // Add the new group to the map
                anagramGroups.put(canonical, group);
            }
        }

        // Return the groups as a new ArrayList
        return new ArrayList<>(anagramGroups.values());
    }

    public static int[] twoSum(int[] nums, int target) {
        // Create a map to store numbers and their indices
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate over each number in the input array
        for (int i = 0; i < nums.length; i++) {
            // Get the current number
            int num = nums[i];
            // Calculate the complement needed to reach the target
            int complement = target - num;

            // Check if the map contains the complement
            if (numMap.containsKey(complement)) {
                // Return the indices of the complement and current number
                return new int[]{numMap.get(complement), i};
            }
            // Store the current number and its index in the map
            numMap.put(num, i);
        }

        // Return an empty array if no pair was found
        return new int[]{};
    }

    public static int[] subarraySum(int[] nums, int target) {
        // Create a HashMap to store cumulative sum and index
        Map<Integer, Integer> sumIndex = new HashMap<>();
        // Initialize the HashMap with 0 sum and index -1
        sumIndex.put(0, -1);
        // Initialize the current sum to 0
        int currentSum = 0;

        // Iterate through the input array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the cumulative sum
            currentSum += nums[i];
            // Check if the required subarray sum exists
            if (sumIndex.containsKey(currentSum - target)) {
                // Return the start and end indices of the subarray
                return new int[]{sumIndex.get(currentSum - target) + 1, i};
            }
            // Store the current sum and its index in the HashMap
            sumIndex.put(currentSum, i);
        }

        // Return an empty array if no subarray is found
        return new int[]{};
    }

    public static List<Integer> removeDuplicates(List<Integer> myList) {
        // Create a new HashSet with unique elements from myList
        Set<Integer> uniqueSet = new HashSet<>(myList);

        // Return a new ArrayList created from the uniqueSet
        return new ArrayList<>(uniqueSet);
    }

    public static boolean hasUniqueChars(String string) {
        // Create a set to store unique characters
        Set<Character> charSet = new HashSet<>();

        // Iterate through each character in the string
        for (char ch : string.toCharArray()) {
            // Check if the character is already in the set
            if (charSet.contains(ch)) {
                return false;
            }
            // Add the character to the set
            charSet.add(ch);
        }

        // If no duplicates found, return true
        return true;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        // Create a set to store unique elements from arr1
        Set<Integer> mySet = new HashSet<>();
        // Create a list to store pairs meeting the conditions
        List<int[]> pairs = new ArrayList<>();

        // Iterate over arr1 and add elements to mySet
        for (int num : arr1) {
            mySet.add(num);
        }

        // Iterate over arr2 and check for pairs with target sum
        for (int num : arr2) {
            // Calculate the complement to reach the target
            int complement = target - num;
            // Check if the complement is in mySet (arr1)
            if (mySet.contains(complement)) {
                // Add the pair (complement, num) to pairs list
                pairs.add(new int[]{complement, num});
            }
        }

        // Return the list of pairs meeting the conditions
        return pairs;
    }
}
