package fibonaccyProblem.recursion;

public class REcursionTest {

    public static void main(String[] args) {
        System.out.println(sum(3));
    }

    public static int sum(int n) {
        if (n >= 1) {
            return sum(n - 1) + n;
        }
        return n;
    }
}
