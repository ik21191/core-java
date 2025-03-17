package com.collection.search;

import java.util.Arrays;

public class BubbleSort {
  public static void bubbleSort(int array[]) {
    System.out.println("UnSorted Array : " + Arrays.toString(array));
    // Outer loop - need n-1 iteration to sort n elements
    for (int i = 0; i < array.length - 1; i++) {

      // Inner loop to perform comparision and swapping between adjacent numbers
      // After each iteration one index from last is sorted
      for (int j = 1; j < array.length - i; j++) {

        // If current number is greater than swap those two
        if (array[j - 1] > array[j]) {
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }



      }
    }
    System.out.println("Sorted : " + Arrays.toString(array));



    /*
     * System.out.println("UnSorted Array : " + Arrays.toString(array)); // Outer loop - need n-1
     * iteration to sort n elements for(int i=0; i < array.length -1; i++){
     * 
     * //Inner loop to perform comparision and swapping between adjacent numbers //After each
     * iteration one index from last is sorted for(int j= 0; j<(array.length-1) -i; j++){
     * 
     * //If current number is greater than swap those two if(array[j] < array[j+1]){ int temp =
     * array[j]; array[j] = array[j+1]; array[j+1] = temp; }
     * 
     * 
     * 
     * } } System.out.println("Sorted : " + Arrays.toString(array));
     */

  }


  public static void main(String[] args) {

    int unSortedArray[] = {5, 2, 6, 3, 4, 1};
    bubbleSort(unSortedArray);


  }

}
