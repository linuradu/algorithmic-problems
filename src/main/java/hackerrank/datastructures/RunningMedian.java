package hackerrank.datastructures;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        //int[] a = new int[1];

        //int addedElements = 0;
        //int half = 0;



         /*
         // Not working due to timeout exception
         for(int a_i=0; a_i < n; a_i++){
            addedElements++;
            if(a.length < addedElements){
                a = Arrays.copyOf(a, addedElements);
            }

            a[a_i] = in.nextInt();
            half = addedElements / 2;

            Arrays.sort(a);

            if((addedElements > 1) && (addedElements % 2 == 0)){
                System.out.println((double)( a[half-1]+a[half])/2 );
            } else {
                System.out.println((double) a[half]);
            }
        }*/

        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        double[] medians = getMedians(a);
        for(int i= 0; i < medians.length; i++){
            System.out.println(medians[i]);
        }
    }

    public static void addNumber(Integer number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if(lowers.size() == 0 || number < lowers.peek()){
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    public static void balance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> lowerHeap = lowers.size() > highers.size() ? highers : lowers;
        PriorityQueue<Integer> higherHeap = lowers.size() > highers.size() ? lowers : highers;

        if((higherHeap.size() - lowerHeap.size()) >=2){
            lowerHeap.add(higherHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> lowerHeap = lowers.size() > highers.size() ? highers : lowers;
        PriorityQueue<Integer> higherHeap = lowers.size() > highers.size() ? lowers : highers;

        if(higherHeap.size() == lowerHeap.size()){
            return ((double) higherHeap.peek() + lowerHeap.peek()) / 2;
        } else {
            return higherHeap.peek();
        }
    }

    public static double[] getMedians(int[] array){
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        double[] medians = new double[array.length];
        for(int i=0; i < array.length; i++){
            addNumber(array[i], lowers, highers);
            balance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }

        return medians;
    }
}
