package org.example;

public class Main {
    static void main() {
        OwnHashMap<Integer, String> theMap = new OwnHashMap<>();

        theMap.put(3, "Three");
        theMap.put(2, "Two");
        theMap.put(1, "One");

        System.out.println("Let's get 1: " + theMap.get(1));

        theMap.put(1, "The new One");
        System.out.println("Let's check 1 after change: " + theMap.get(1));

        System.out.println("\nNow we have to remove 3: " + theMap.remove(3));
        System.out.println("Let's check 3: " + theMap.get(3));
        System.out.println("The size now is: " + theMap.size());

        OwnHashMap<Integer, String> theSecondMap = new OwnHashMap<>();
        theSecondMap.put(2, "Two");
        theSecondMap.put(1, "The new One");
        System.out.println("\nFirst map: " + theMap);
        System.out.println("Second map: " + theSecondMap);
        System.out.println("HashMaps are equals: " + theMap.equals(theSecondMap));
    }
}
