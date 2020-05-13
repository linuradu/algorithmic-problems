package hackerrank.bundlesmax;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BundlesMaxTest {

    private static AtomicInteger maxCount = new AtomicInteger(0); // TODO change this with normal

    public static void main(String[] args) {
        final int budget = 50;
        final List bundleQuantities = Arrays.asList(50, 18, 3, 6);
        final List bundleCosts = Arrays.asList(40, 15, 4, 6);

        System.out.println(budgetShopping(budget, bundleCosts, bundleQuantities));
    }


    private static int budgetShopping(final int budget, final List bundleCosts, final List bundleQuantities) {

        // Initial call
        calculateRecursive(budget, bundleCosts, bundleQuantities, 0, 0);

        return maxCount.get();
    }

    private static void calculateRecursive(final int budget, final List<Integer> bundleCosts, final List<Integer> bundleQuantities, final int position, final int currentCount) {

        // exit condition
        if (budget <= 0 || position == bundleCosts.size()) {
            if (currentCount > maxCount.get()) {
                maxCount.set(currentCount);
            }

            return;
        }

        // iterate over all combinations
        for (int i = 0; i <= budget / bundleCosts.get(position); i++) {

            calculateRecursive(
                    budget - (i * bundleCosts.get(position)),
                    bundleCosts,
                    bundleQuantities,
                    position + 1,
                    currentCount + (i * bundleQuantities.get(position))
            );
        }


    }


}
