import java.util.*;
import java.lang.*;

public class XORSequence {

  public static int[] arr;
  public static long len = (long)(Math.pow(10, 15)) + 1;

  public static void main(String[] args) {
    generateArrayLarge();

    System.out.println(arr);
  }

  public static void generateArrayLarge() {
    arr = new int[len];
    arr[0] = 0;

    for(long i = 1; i < len; i++) {
      arr[i] = arr[i-1] ^ i;
    }
  }
}
