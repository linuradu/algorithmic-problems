package fibonaccyProblem;

import java.util.stream.Stream;

public class FibonacciProblemTest1 {

    public static void main(String[] args) {
        Stream.iterate(new int[]{0, 1}, array -> new int[]{array[1], array[0] + array[1]})
                .limit(10)
                .forEach(array -> System.out.println(array[0]));
    }
}
