package hackerrank.datastructures;

import java.util.Scanner;

public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {

        int result = 0;

        int letterscount[] = new int[26];
        for (char c : first.toCharArray()) {
            letterscount[c - 'a']++;
        }

        for (char c : second.toCharArray()) {
            letterscount[c - 'a']--;
        }

        for (int i : letterscount) {
            result += Math.abs(i);
        }


        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
