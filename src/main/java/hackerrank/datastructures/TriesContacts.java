package hackerrank.datastructures;

import java.util.Arrays;
import java.util.Scanner;

public class TriesContacts {
    private static int NUMBER_OF_CHARACTERS = 26;

    private class Node {
        int count;
        Node[] children;

        Node() {
            this.count = 0;
            this.children = new Node[NUMBER_OF_CHARACTERS];
            Arrays.fill(children, null);
        }
    }

    void processOperation(String op, String contact, Node trie) {
        switch (op) {
            case "add":
                addContactInTrie(trie, contact);
                break;
            case "find":
                printContactsCountByName(trie, contact);
        }
    }

    void addContactInTrie(Node trie, String contact) {
        Node current = trie;

        for (char c : contact.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }

            current.children[index].count++;
            current = current.children[index];
        }

    }

    void printContactsCountByName(Node trie, String contact) {
        //System.out.println(this.contacts.parallelStream().filter(c -> c.contains(contact)).count());
        Node current = trie;

        for (char c : contact.toCharArray()) {
            int index = c - 'a';
            current = current.children[index];

            if (current == null) {
                break;
            }
        }

        System.out.println(current == null ? 0 : current.count);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Node trie = new TriesContacts().new Node();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();

            new TriesContacts().processOperation(op, contact, trie);
        }
    }
}
