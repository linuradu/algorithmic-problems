package hackerrank.arrayrotation;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int d = 4;

        int[] arrayNew = new int[a.length];

        System.arraycopy(a, d, arrayNew, 0, a.length-d);
        System.arraycopy(a, 0, arrayNew, a.length-d, d);

        System.out.println(Arrays.toString(arrayNew));

    }


}
