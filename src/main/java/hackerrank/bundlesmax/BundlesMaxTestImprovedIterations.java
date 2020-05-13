package hackerrank.bundlesmax;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BundlesMaxTestImprovedIterations {

    private static Integer iterations = 0;
    private static Integer maxCount = 0;
    private static String maxCountItems = "";

    public static void main(String[] args) {
        final int budget = 50;
        final List<Integer> bundleQuantities = Arrays.asList(50, 18, 3, 6);
        final List<Integer> bundleCosts = Arrays.asList(40, 15, 4, 6);

        final List<BundleOffer> offers = IntStream.range(0, bundleQuantities.size())
                .boxed()
                .map(i -> new BundleOffer(bundleQuantities.get(i), bundleCosts.get(i)))
                .collect(Collectors.toList());


        calculateRecursive(budget, offers, 0, 0, "");
        System.out.println("Iterations: " + iterations);
        System.out.println(maxCount);
        System.out.println(maxCountItems);

    }

    private static void calculateRecursive(final int budget, List<BundleOffer> offers, final int position, final int currentCount, final String bundlesCollected) {
        ++iterations;

        /**
         * Exit condition
         * If the budget is 0 or the list of offers is exceeded
         */
        if (budget == 0 || position == offers.size()) {
            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxCountItems = bundlesCollected;
            }

            return;
        }

        int maxQuantitiesForPosition = budget / offers.get(position).getPrice();
        int i = position == offers.size() - 1 ? maxQuantitiesForPosition : 0;
        while (i <= maxQuantitiesForPosition) {
            calculateRecursive(
                    budget - (i * offers.get(position).getPrice()),
                    offers,
                    position + 1,
                    currentCount + (i * offers.get(position).getQuantity()),
                    bundlesCollected + (i * offers.get(position).getQuantity()) + "-" + offers.get(position).getPrice() + " "
            );

            i++;
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
