import java.util.*;
import java.lang.*;

public class BinarySearchImpl {
  public static void main(String[] args) {
    int[] arr = {6, 10, 2, 8, 3, 9, 1, 4, 5, 7};

    mergesort(arr, 0, arr.length-1);

    for(int i: arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void mergesort(int[] arr, int lo, int hi) {
    int mid = (lo+hi)/2;

  }

  public static void merge(int lo, int hi) {

  }
}
