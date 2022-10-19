package com.vtxlab.app;

import static com.vtxlab.utility.SortUtil.sort;

import java.util.Hashtable;
import java.util.Iterator;

import com.vtxlab.interfaces.MathCalculator;
import com.vtxlab.interfaces.MathMultiOperation;
import com.vtxlab.interfaces.MathOperation;
import com.vtxlab.model.MathOperationHolder;
import com.vtxlab.utility.SortHelper;
import com.vtxlab.utility.SortUtil;

public class Lambda {
  // Driver program
  public static void main(String[] args) { // main
    // Lambda
    MathOperation additionOperation = (x, y) -> {
      int z = x + y;
      return z;
    };
    MathOperation substractOperation = (x, y) -> x - y;
    MathOperation MultiplierOperation = (x, y) -> x * y;
    MathOperation DivisionOperation = (x, y) -> x / y;
    MathOperation additionOperation2 = (x, y) -> {
      int z = 100;
      return z + x - y;
    };
    MathCalculator mathCalculator = () -> {
      System.out.println("abc");
    };

    System.out.println(additionOperation.compute(3, 4)); // 7
    System.out.println(additionOperation2.compute(7, 9)); // 98
    System.out.println(substractOperation.compute(6, 2)); // 4
    System.out.println(MultiplierOperation.compute(6, 3)); // 18
    System.out.println(DivisionOperation.compute(10, 2)); // 5
    mathCalculator.print(); // abc

    // No Lambda
    MathOperation noLambda = new MathOperation() {
      @Override
      public int compute(int x, int y) {
        return x + y;
      }
    };
    System.out.println(noLambda.compute(3, 4)); // 7

    // More than 1 method
    MathMultiOperation noLambda2 = new MathMultiOperation() {
      @Override
      public void firstMethod() {
        System.out.println("printSometing");
      }

      @Override
      public void secondMethod(String s) {
        System.out.println(s);
      }
    };
    noLambda2.firstMethod();
    noLambda2.secondMethod("ABC");

    // No Lambda (implements)
    MathOperation noLambda3 = new MathOperationHolder();
    System.out.println(noLambda3.compute(10, 3)); // 13

    // 1. Create Hashtable
    Hashtable<Integer, String> hashtable = new Hashtable<>();

    // 2. Add mappings to hashtable , self-define the key
    hashtable.put(1, "A");
    hashtable.put(1, "B");
    hashtable.put(3, "C");

    System.out.println(hashtable);

    // 3. Access a mapping by key
    String value = hashtable.get(1); // A
    System.out.println(value);

    // 4. Remove a mapping
    hashtable.elements(); // 3 is deleted

    // 5. Iterate over mappings
    Iterator<Integer> itr = hashtable.keySet().iterator();
    while (itr.hasNext()) {
      Integer key = itr.next();
      String mappedValue = hashtable.get(key);

      System.out.println("Key: " + key + ", Value: " + mappedValue);
    }
    String NewString = "Hello";
    NewString.concat("World");
    // NewString = NewString.concat("World");
    System.out.println(NewString);

    // selection sort
    SortHelper selectionSort = (int[] arr) -> {
      SortUtil.selectionSort(arr);
    };

    // insertion sort
    SortHelper insertionSort = (int[] arr) -> {
      SortUtil.insertionSort(arr);
    };

    int[] arr1 = { 1, 3, 5, 11 };
    int[] arr2 = { 1, 3, 5, 11 };
    int[] arr3 = { 1, 3, 5, 11 };
    int[] arr4 = { 1, 3, 5, 11 };

    sort(arr1, selectionSort); // [1, 2, 3, 4]
    sort(arr2, insertionSort); // [1, 2, 3, 4]
    sort(arr3, selectionSort); // [1, 2, 3, 4]
    sort(arr4, insertionSort); // [1, 2, 3, 4]

  }
}
