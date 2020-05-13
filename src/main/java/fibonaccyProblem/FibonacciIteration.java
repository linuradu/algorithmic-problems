package fibonaccyProblem;

import java.util.Arrays;

public class FibonacciIteration {

    public static void main(String[] args) {
        int elements[] = new int[10];
        elements[0] = 0;
        elements[1] = 1;

        for(int i = 2; i< elements.length; i++){
            elements[i] = elements[i-2] + elements[i-1];
        }

        System.out.println(Arrays.toString(elements));

    }

}
