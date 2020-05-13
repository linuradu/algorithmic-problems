package fibonaccyProblem.recursion;

import java.util.stream.Stream;

public class FibonacciProblem {

    public static void main(String[] args) {
//        System.out.println(fibonacci(0, 10));
//        java8();

        System.out.println(fib(8));
    }

    public static int fibonacci(int n, int stop) {
        if (n >= stop) {
            return n;
        }
        System.out.println(n);
        return fibonacci(n+1, stop) + fibonacci(n+2, stop);
    }

    public static long fib(long n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void java8(){
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(x -> System.out.println(x));
    }
}
