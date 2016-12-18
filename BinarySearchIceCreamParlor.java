// Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool
// together m dollars for ice cream. On any given day, the parlor offers a line
// of n flavors. Each flavor, i, is numbered sequentially with a unique ID number
// from 1 to n and has a cost, c_i, associated with it.

// Given the value of m and the cost of each flavor for t trips to the Ice Cream
// Parlor, help Sunny and Johnny choose two distinct flavors such that they spend
// their entire pool of money (m) during each visit. For each trip to the parlor,
// print the ID numbers for the two types of ice cream that Sunny and Johnny
// purchase as two space-separated integers on a new line. You must print the
// smaller ID first and the larger ID second.

// Note: Two ice creams having unique IDs i and j may have the same cost
// (i.e., c_i == c_j).

import java.util.*;

public class BinarySearchIceCreamParlor {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    while(t-->0) {
      int m = in.nextInt();
      int n = in.nextInt();
      IceCream[] icList = new IceCream[n];
      for(int i = 0; i < n; i++) {
        icList[i] = new IceCream((i+1), in.nextInt());
      }
      Arrays.sort(icList);
      findPair(icList, m);
    }
  }

  public static void findPair(IceCream[] icList, int m) {
    for(int i = 0; i < icList.length; i++) {
      int priceToFind = m - icList[i].cost;
      if (priceToFind < 1) continue;
      int ind = binarysearch(icList, priceToFind, i);
      if (ind != -1) {
        IceCream a = icList[i]; IceCream b = icList[ind];
        System.out.println((a.id < b.id) ? icList[i].id+" "+icList[ind].id : icList[ind].id+" "+icList[i].id);
        return;
      }
    }
  }

  public static int binarysearch(IceCream[] arr, int k, int used) {
    int mid = 0;
    int lo = 0;
    int hi = arr.length-1;

    while(lo <= hi) {
      mid = (lo + hi)/2;
      if (k < arr[mid].cost) {
        hi = mid-1;
      } else if (k > arr[mid].cost) {
        lo = mid+1;
      } else {
        if(mid == used) {
          return -1;
        }
        return mid;
      }
    }
    return -1;
  }
}

class IceCream implements Comparable{
  public int id;
  public int cost;

  public IceCream(int i, int c) {
    id = i; cost = c;
  }

  public int compareTo(Object o) {
    IceCream ic = (IceCream) o;
    if(this.cost > ic.cost) {
      return 1;
    } else if (this.cost < ic.cost) {
      return -1;
    }
    return 0;
  }
}
