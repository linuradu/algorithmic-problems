package hackerrank.sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
considering the array is sorted will be searched the middle element and verified if is lover or greater that the searched value.
Will decide to repeat the process until will find the element
 */

class IceCream implements Comparable{
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
        this.flavor = flavor;
        this.index = index;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof IceCream)){
            throw new ClassCastException();
        }

        IceCream ic = (IceCream) o;

        if (this.flavor < ic.flavor){
            return -1;
        } else if(this.flavor > ic.flavor){
            return 1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof IceCream)){
            return false;
        }

        IceCream ic = (IceCream) o;

        return this.flavor == ic.flavor;// && this.index == ic.index;
    }

}

public class BinarySearch {

    public static int binarySearch(int first, int last, IceCream[] arr, int search) {
        if ( first > last){
            return -1;
        }
        int middle = first + ((last - first)/2); //(first + last) / 2; //

        if(arr[middle].flavor == search){
            return middle;
        } else if(arr[middle].flavor > search){
            return binarySearch(first, middle-1, arr, search);
        } else {
            return binarySearch(middle+1, last, arr, search);
        }

    }

    public static void main(String[] args) {

        int t;
        int n, m;

        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for(int test = 0; test < t; test++) {

            m = in.nextInt();
            n = in.nextInt();
            IceCream[] arr = new IceCream[n];

            for (int i = 0; i < n; i++)
                arr[i] = new IceCream(in.nextInt(), i + 1);

            Arrays.sort(arr);

           /*for(IceCream i: arr){
               System.out.print(i.flavor + " ");
           }*/

            int firstIndex = 100000, secondIndex = 100000;
            for(int i = 0; i < n - 1 ; i++) {
                int search = m - arr[i].flavor;
                if(search >= arr[i].flavor) {
                    int index = binarySearch( i + 1, n - 1, arr, search);
                    if( index != -1 ) {
                        System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                        break;

                    }
                }
            }

        }

    }
}
