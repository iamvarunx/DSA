package Sorting;

import java.util.Arrays;

public class BubbleSort {
    
    public static void main(String args[])
    {
        int b[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n=b.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i -1 ; j++) {
                if (b[j] > b[j + 1]) {
                    temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }
      System.out.println(Arrays.toString(b));
    }
}