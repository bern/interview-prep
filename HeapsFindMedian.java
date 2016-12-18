/*

  NOTE: INCOMPLETE

*/

// Given an input stream of n integers, you must perform the following task for
// each ith integer:

// Add the ith integer to a running list of integers.

// Find the median of the updated list (i.e., for the first element through the
// ith element).

// Print the list's updated median on a new line. The printed value must be a
// double-precision number scaled to decimal place (i.e., 12.3 format).

import java.util.*;

public class HeapsFindMedian {
  public static void main(String[] args) {
    Heap h = new Heap(8);
    h.heapify(4);
    h.heapify(7);
    h.heapify(1);
    h.heapify(5);
    h.heapify(2);
    h.heapify(8);
    // h.heapify(8);
    // h.heapify(10);
    for(int e: h.heap) {
      System.out.print(e+" ");
    }
    System.out.println();
  }
}

class Heap {
  public ArrayList<Integer> heap;
  public int size;

  public Heap(int n) {
    size = n;
    heap = new ArrayList<Integer>(n);
  }

  public void heapify(int i) {
    heap.add(i);
    int currInd = heap.size()-1;
    while(currInd > 0 && heap.get(currInd) < heap.get((currInd-1)/2)) {
      int temp = heap.get(currInd);
      heap.set(currInd, heap.get((currInd-1)/2));
      heap.set((currInd-1)/2, temp);
      currInd = (currInd-1)/2;
    }
  }
}
