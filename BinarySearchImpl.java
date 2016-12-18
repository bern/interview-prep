import java.util.*;
import java.lang.*;

public class BinarySearchImpl {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 5, 5, 5, 5, 5, 6, 7, 8, 9, 10};

    int ind2 = binarysearch(arr, 2);
    int ind4 = binarysearch(arr, 4);
    int ind5 = binarysearch(arr, 5);

    System.out.println("index of 2 is "+ind2);
    System.out.println("index of 4 is "+ind4);
    System.out.println("index of 5 is "+ind5);
  }

  public static int binarysearch(int[] arr, int k) {
    int mid = 0;
    int lo = 0;
    int hi = arr.length-1;

    while(lo <= hi) {
      mid = (lo + hi)/2;
      if (k < arr[mid]) {
        hi = mid-1;
      } else if (k > arr[mid]) {
        lo = mid+1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
