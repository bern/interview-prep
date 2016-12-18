import java.util.*;
import java.lang.*;

public class MergeSortImpl {
  public static void main(String[] args) {
    int[] arr = {6, 10, 2, 8, 3, 9, 6, 1, 4, 5, 7};

    mergesort(arr, 0, arr.length);

    printArr(arr);
  }

  public static void mergesort(int[] a, int lo, int hi) {
    // If our array size is 1 (since hi represents maxIndex+1).
    if (hi - lo < 2) return;

    // Else, find the midpoint..
    int mid = (hi+lo)/2;

    // Partition our [lo:(hi-1)] subsection..
    mergesort(a, lo, mid);
    mergesort(a, mid, hi);

    // Merge the result.
    merge(a, lo, mid, hi);
  }

  public static void merge(int a[], int lo, int mid, int hi) {
    // Make a copy of a that will serve as a master list.
    int[] b = new int[a.length];
    for(int i = 0; i < a.length; i++) {
      b[i] = a[i];
    }

    // Partition 1 (tracked by i) is [lo:(mid-1)] so we start at lo.
    // Partition 2 (tracked by j) is [mid:(hi-1)] so we start at mid.
    int i = lo; int j = mid; int ind = lo;

    while(ind < hi) {
        // Perform appropriate merge into a based on master list (b) values.
        if(i < mid && (j >= hi || b[i] <= b[j])) {
          a[ind] = b[i];
          i++;
        } else if (j <= hi && b[j] <= b[i]){
          a[ind] = b[j];
          j++;
        }
        ind++;
    }
  }

  public static void printArr(int[] a) {
    for(int i: a) System.out.print(i + " ");
    System.out.println();
  }
}
