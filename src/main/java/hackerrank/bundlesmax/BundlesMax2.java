package hackerrank.bundlesmax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/*
budged for purchasing the maths notebooks
there are several stores that "sell bundels of notebooks" at various prices
she can only purchase full bundles
she want to purchase as many notebooks as she case within her budget

Q:
determine the maximum number of notebooks Helen can purchase with the amount she is given



first:
bundles 20 notebooks - 12$ each

second:
bundles of only one notebook for 2$ each


She can buy
- 4 bundles of 20 = 48$
- 1 bundles of 1 =

total: 81 notebooks



n: number of dollars
bundleQuantities: the number of notebooks in a bundle at shop[i]
bundleCosts: the costs of a bundle of notebooks


budget:

Quantity/price

40$ -> 50b

15$ -> 18

5$ -> 5b


reccurstion:
for every method is keeping the params valuse and variables values
 */
public class BundlesMax2 {

    public static void main(String[] args) {
        int budget = 50;
        List bundleQuantities = Arrays.asList(50, 18, 3, 6);
        List bundleCosts = Arrays.asList(40, 15, 4, 6);

        System.out.println(budgetShopping(budget, bundleCosts, bundleQuantities));
    }

    private static AtomicInteger maxItemsToBuy = new AtomicInteger(0);

    static int budgetShopping(int budget, List<Integer> bundleCosts, List<Integer> bundleQuantities) {


        calculateRecursive(budget, bundleCosts, bundleQuantities, 0, 0);

        return maxItemsToBuy.get();
    }

    static void calculateRecursive(int budget, final List<Integer> cost, final List<Integer> quantity, int position, int currentItemsCount) {
        // there is No budget or array is end
        if (budget == 0 || position == cost.size()) {
            if (currentItemsCount > maxItemsToBuy.get()) {
                maxItemsToBuy.set(currentItemsCount);
            }

//            if (position == cost.size()) {
//                System.out.println("One complete iteration");
//            }
            return; // get out from the cycle
        }


        for (int i = 0; i <= (budget / cost.get(position)); i++) {
            System.out.println("Executed position: " + position);
            calculateRecursive(budget - i * cost.get(position), cost, quantity, position + 1, currentItemsCount + i * quantity.get(position)); // add a log after this
        }
    }
}


//    final IntStream stream = IntStream.range(0, (n / cost.get(position)) + 1);
//    stream.parallel().forEach(i -> {
//        calculateRecursive(n - i * cost.get(position), cost, quantity, max, position + 1, count + i * quantity.get(position));
//    });
