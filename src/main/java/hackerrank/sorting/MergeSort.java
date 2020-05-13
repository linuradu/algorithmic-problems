package hackerrank.sorting;

import java.util.Scanner;

public class MergeSort {

    private static long countInversions(int[] arr) {
        int[] aux = arr.clone();
        return mergesort(arr, 0, arr.length - 1, aux);
    }

    private static long mergesort(int[] arr, int leftStart, int rightEnd, int[] aux) {
        if (leftStart >= rightEnd)
            return 0;

        int middle = (leftStart + rightEnd) / 2; // leftStart + (rightEnd - leftStart) / 2;

        long count = 0;
        count += mergesort(aux, leftStart, middle, arr);
        count += mergesort(aux, middle + 1, rightEnd, arr);
        count += merge(arr, leftStart, middle, rightEnd, aux);

        return count;
    }

    private static long merge(int[] arr, int leftStart, int middle, int rightEnd, int[] aux) {
        long count = 0;
        int left = leftStart;
        int right = middle + 1;
        int index = leftStart;

        /*while (left <= middle || right <= rightEnd) {

            if (left > middle) {
                arr[index++] = aux[right++];
            } else if (right > rightEnd) {
                arr[index++] = aux[left++];
            } else if (aux[left] <= aux[right]) {
                arr[index++] = aux[left++];
            } else {
                arr[index++] = aux[right++];
                count += middle + 1 - left;
            }
        }*/

        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd+1;
        int size = rightEnd - leftStart +1;

        while(left <= leftEnd && right <= rightEnd){
            if(arr[left] <= arr[right]){
                aux[index] = arr[left];
                left++;
            } else{
                aux[index]= arr[right];
                right++;

                count += middle + 1 - left;
            }
            index++;
        }

        System.arraycopy(arr, left, aux, index, leftEnd - left +1);
        System.arraycopy(arr, right, aux, index, rightEnd - right +1);
        System.arraycopy(aux, leftStart, arr, leftStart, size ) ;

        return count;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);

            for(int i: arr){
                System.out.print(i + " ");
            }

            System.out.println("\n"+result);
        }
        in.close();
    }
}
