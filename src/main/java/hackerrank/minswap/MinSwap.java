package hackerrank.minswap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSwap {

    public static void main(String[] args) {
        minSwaps(new int[4]);
    }

    static int minSwaps(int[] arr) {

        arr = new int[]{7, 1, 3, 2, 4, 5, 6, 0};
        int n = arr.length;


        Map<Integer, Integer> arrayPositions = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arrayPositions.put(arr[i], i);
        }


        System.out.println(arrayPositions);


        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);

        // Initialize result
        int ans = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++)
        {
            // already swapped and corrected or
            // already present at correct pos
            if (vis[i] || arrayPositions.get(i) == i)
                continue;

            // find out the number of  node in
            // this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!vis[j])
            {
                vis[j] = true;

                // move to next node
                j = arrayPositions.get(j);
                cycle_size++;
            }

            // Update answer by adding current cycle.
            if(cycle_size > 0)
            {
                ans += (cycle_size - 1);
            }
        }

        System.out.println(ans);
        return 1;
    }
}
