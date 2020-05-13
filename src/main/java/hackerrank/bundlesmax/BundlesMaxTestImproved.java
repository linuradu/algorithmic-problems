package hackerrank.bundlesmax;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BundlesMaxTestImproved {

    private static Integer iterations = 0;
    private static Integer maxCount = 0;

    public static void main(String[] args) {
        final int budget = 50;
        final List<Integer> bundleQuantities = Arrays.asList(50, 18, 3, 6);
        final List<Integer> bundleCosts = Arrays.asList(40, 15, 4, 6);

        final List<BundleOffer> offers = IntStream.range(0, bundleQuantities.size())
                .boxed()
                .map(i -> new BundleOffer(bundleQuantities.get(i), bundleCosts.get(i)))
                .collect(Collectors.toList());


        calculateRecursive(budget, offers, 0, 0);
        System.out.println("Iterations: " + iterations);
        System.out.println(maxCount);
    }

    private static void calculateRecursive(final int budget, List<BundleOffer> offers, final int position, final int currentCount) {
        ++iterations;

        /**
         * Exit condition
         * If the budget is 0 or the list of offers is exceeded
         */
        if (budget == 0 || position == offers.size()) {
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }

            return;
        }

        // Iterate over all combinations
        for (int i = 0; i <= budget / offers.get(position).getPrice(); i++) {
            calculateRecursive(
                    budget - (i * offers.get(position).getPrice()),
                    offers,
                    position + 1,
                    currentCount + (i * offers.get(position).getQuantity())
            );
        }


    }

    static class BundleOffer {
        private int quantity;
        private int price;

        private BundleOffer(final int quantity, final int price) {
            this.quantity = quantity;
            this.price = price;
        }

        int getQuantity() {
            return quantity;
        }

        int getPrice() {
            return price;
        }
    }
}
