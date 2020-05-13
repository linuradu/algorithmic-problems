package hackerrank.sorting;

import java.util.Scanner;

public class BubbleSort {

    // is the classic sorting method

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        processArraySortingAndPrintResults(a);
    }

    public static void processArraySortingAndPrintResults(int[] array) {
        int totalNumberOfSwaps = 0;

        for (int i = 0; i < array.length; i++) {
            int numberOfSwaps = 0;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    totalNumberOfSwaps++;
                    numberOfSwaps++;
                }
            }

            if (numberOfSwaps == 0) {
                break;
            }
        }

        System.out.format("Array is sorted in %d swaps.\n", totalNumberOfSwaps);
        System.out.println("First Element: " + array[0]);
        System.out.println("Last Element: " + array[array.length - 1]);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
