package hackerrank.bundlesmax;

public class BundlesMax {

    public static void main(String[] args) {
        System.out.println(budgetShopping(0, new int[2], new int[2]));
    }

    static int budgetShopping(int budget, int[] bundleQuantities, int[] bundleCosts) {

        budget = 50;
        bundleQuantities = new int[]{20, 19};
        bundleCosts = new int[]{24, 20};

        if (    budget <= 0
                || bundleCosts == null || bundleQuantities == null
                || bundleCosts.length == 0 || bundleQuantities.length == 0
                || bundleCosts.length != bundleQuantities.length
        ) {
            return 0;
        }



        final int[] max = {0};

        calculateRecursive(budget, bundleCosts, bundleQuantities, max, 0, 0);

        return max[0];
    }

    static void calculateRecursive(int n, int[] cost, int[] quantity, int[] max, int position, int count) {
        if (n == 0 || position == cost.length) {
            if (count>max[0]) {
                max[0] = count;
            }
            return;
        }
        for (int i = 0; i <= n/cost[position]; i++) {
            calculateRecursive(n - i * cost[position], cost, quantity, max, position + 1, count + i * quantity[position]);
        }
    }
}
