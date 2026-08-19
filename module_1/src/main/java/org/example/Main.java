package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyImmutableClass myImmutableObj = new MyImmutableClass();

        // java: name has private access in org.example.MyImmutableClass
        // myImmutableObj.name = "SomeName";

        System.out.println(myImmutableObj.getName());

        // Exception in thread "main" java.lang.UnsupportedOperationException
        //	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1067)
        // List<String> siblings = myImmutableObj.getSiblings();
        // siblings.add("newOne");

        System.out.println(myImmutableObj.getSiblings());

        MyImmutableClass mySecondImmutableObj = new MyImmutableClass();
        MyImmutableClass.MutableClass mutableObj = myImmutableObj.getMutableObj();

        System.out.println(mutableObj.name);
        mutableObj.name = "New Name";
        System.out.println(mutableObj.name);
        System.out.println("Objects are equal: " + myImmutableObj.equals(mySecondImmutableObj));

        myImmutableObj.setMutableFieldObjName("New Name");
        System.out.println(myImmutableObj.getMutableObj().name);
        System.out.println("Objects are equal after name change: " + myImmutableObj.equals(mySecondImmutableObj));
    }
}