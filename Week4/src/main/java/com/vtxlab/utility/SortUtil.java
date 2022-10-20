package com.vtxlab.utility;

public final class SortUtil {

  public static final void sort(int[] arr, IntSortHelper sortHelper) {
    sortHelper.sort(arr);
  }

  // A utility function to swap two elements
  public static final void swap(int[] arr, int i, int j) { // array pass by reference value
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static final void print(int[] arr) {
    for (int i : arr) {
      System.out.print(i + ", ");
    }
  }

  public static void selectionSort(int[] arr) {
    // [11, 5, 7, 19, 4, 1, 7], i = 0, j = 1
    // [1, 5, 7, 19, 4, 11, 7], i = 1?
    // [1, 4, 7, 19, 5, 11, 7], i = 2?
    // first loop -> count elements, from left to right
    for (int i = 0; i < arr.length - 1; i++) { // i = 3
      // second loop -> find the smallest number among the numbers
      int min = arr[i];
      int index = 0;
      // int temp = 0;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < min) { // arr[1] arr[0]
          min = arr[j];
          index = j;
        }
      }
      // Swap
      if (index != 0) {
        swap(arr, index, i);
      }
    }
  }

  public static void insertionSort(int[] arr) { // -> interface
    // [11, 5, 7, 19, 4, 1, 7] when i = 0
    // [5, 11, 7, 19, 4, 1, 7] when i = 1
    // [5, 7, 11, 19, 4, 1, 7] when i = 1, after line 29
    // [5, 7, 11, 19, 4, 1, 7] when i = 2
    // [5, 7, 11, 19, 4, 1, 7] when i = 3
    // [5, 7, 11, 4, 19, 1, 7] when i = 3, after line 29
    // result: [1, 4, 5, 7, 7, 11, 19]
    // for loop and arrary
    for (int i = 0; i <= arr.length - 2; i++) { // when i = 3
      int n = 0;
      int newValue = arr[i + 1]; // new = 4
      int oldValue = arr[i]; // old = 19

      while (newValue < oldValue) { // 4 < 11, i = 3
        // Swap
        swap(arr, i - n - 1, i - n);
        // After swap
        newValue = arr[i - n];
        if (i - n - 1 < 0) {
          break;
        }
        oldValue = arr[i - n - 1]; // outOfIndex
        n++;
      }
    }
  }

  public static boolean isAdult(int age) {
    // Early Return
    if (age >= 18) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = { 7, 1, 7, 2, 4 };
    // insertionSort(arr);
    selectionSort(arr);
    print(arr);
  }
  
}
