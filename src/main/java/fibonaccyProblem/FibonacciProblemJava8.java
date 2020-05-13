package fibonaccyProblem;

import java.util.stream.Stream;

public class FibonacciProblemJava8 {

    public static void main(String[] args) {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(x -> System.out.println(x[0]));
    }
}
