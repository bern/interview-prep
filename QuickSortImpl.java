import java.util.*;
import java.lang.*;

public class QuickSortImpl {
  public static void main(String[] args) {
    int[] arr = {6, 10, 2, 8, 3, 9, 1, 4, 5, 7};

    quicksort(arr, 0, arr.length-1);

    for(int i: arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static int partition(int[] arr, int lo, int hi) {
    // Arbritrarily select the pivot as the first element.
    int piv = arr[lo];

    // Start the indices outside of the boundaries of the subsection.
    int i = lo-1; int j = hi+1;

    // Until we quit internally...
    while (true) {
      // Advance i to the right until it hits an element that is >= piv.
      do {
        i++;
      } while(arr[i] < piv);

      // Advance j to the left until it hits an element that is <= piv.
      do {
        j--;
      } while(arr[j] > piv);

      // If we overlap or match the indices, we're done.
      if (i >= j) return j;

      // Swap i and j, repeat loop.
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  public static void quicksort(int[] arr, int lo, int hi) {
    // When we try and quicksort a subsection of size one or zero, we return.
    if (lo < hi) {
      // Sort array such that what once was the element at [lo] is now
      // the properly indexed pivot. Return the index of that pivot.
      int pivInd = partition(arr, lo, hi);

      // Sort the lower half of the array, including the pivot.
      quicksort(arr, lo, pivInd);

      // Sort the upper half of the array, not including the pivot.
      quicksort(arr, pivInd+1, hi);
    }
  }
}
