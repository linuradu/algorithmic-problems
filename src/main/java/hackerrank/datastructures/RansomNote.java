package hackerrank.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
    public static String couldCreateUntraceableReplica(String magazine[], String ransom[]) {
        Map<String, Integer> magazineWords = new HashMap<>();
        for (int i = 0; i < magazine.length; i++) {
            magazineWords.merge(magazine[i], 1, Integer::sum);
        }

        for (int i = 0; i < ransom.length; i++) {
            int wordCount = magazineWords.get(ransom[i]);
            if (wordCount < 1) {
                return "No";
            }
            magazineWords.put(ransom[i], wordCount - 1);
        }

        return "Yes";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }

        System.out.print(couldCreateUntraceableReplica(magazine, ransom));
    }
}
