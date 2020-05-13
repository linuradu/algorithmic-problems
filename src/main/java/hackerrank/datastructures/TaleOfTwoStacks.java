package hackerrank.datastructures;

import java.util.Scanner;
import java.util.Stack;

public class TaleOfTwoStacks {

    /*
    //    This is the performant one
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() { // see the last value
            ensureOldestQueue();
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            ensureOldestQueue();
            return stackOldestOnTop.pop();
        }

        public void ensureOldestQueue(){
            if(stackOldestOnTop.isEmpty()){
                while(stackNewestOnTop.size() > 0){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
    }
     */

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            while(stackOldestOnTop.size() > 0){
                stackNewestOnTop.push(stackOldestOnTop.pop());
            }

            stackNewestOnTop.push(value);
        }

        public T peek() { // see the last value
            while(stackNewestOnTop.size() > 0){
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }

            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            while(stackNewestOnTop.size() > 0){
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }

            return stackOldestOnTop.pop();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
