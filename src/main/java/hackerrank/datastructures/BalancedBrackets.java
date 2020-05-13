package hackerrank.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static Map<Character, Character> pairs = new HashMap<>();

    static {
        pairs.put('{', '}');
        pairs.put('[', ']');
        pairs.put('(', ')');
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isOpenTerm(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (!matches(top, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isOpenTerm(char c) {
        return pairs.get(c) != null;
    }

    public static boolean matches(char openTerm, char closeTerm) {
        return closeTerm == pairs.get(openTerm);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
