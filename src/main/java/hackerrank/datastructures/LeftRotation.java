package hackerrank.datastructures;

import java.util.Scanner;

public class LeftRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int rotatedArr[] = new int[n];

        // Copy segments of shifted elements to rotated array:

        //System.arraycopy(src, srcPos, dest, destPos, length);

        /*
        The algorithm is as follow:

        ex:
        5
        4
        1 2 3 4 5
        result: 5 1 2 3 4

        I.   create new empty array with the same length
        II.  copy in the empty array form k position the array
             5 0 0 0 0

        III. copy form start to k position to the new array
             5 1 2 3 4

         */
        System.arraycopy(a, k, rotatedArr, 0, n-k);
        System.arraycopy(a, 0, rotatedArr, n-k, k);

        for(int i=0; i<n; i++){
            System.out.print(rotatedArr[i] + " ");
        }
    }
}
