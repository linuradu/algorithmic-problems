package hackerrank.concepts;

import java.util.Scanner;
import java.util.Timer;

public class FibonacciNumbers {

    /*public static int fib(int n){
        if(n<=0){
            return 0;
        } else if(n==1){
            return 1;
        } else{
            return fib(n-1) + fib(n-2);
        }
    }*/

    static int fibonacci(int n, int memo[]) {
        if(n<=0){
            return 0;
        } else if(n==1){
            return 1;
        } else if(memo[n] <= 0 ){
            memo[n] = fibonacci(n-1, memo) + fibonacci(n-2, memo);
        }

        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int[] memo = new int[n+1];

        System.out.println(fibonacci(n, memo));
    }
}
