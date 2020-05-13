package codility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class SolutionSlices {

    private static final double MAX_ALLOWED_PRODUCT = 1_000_000_000.0;

    public static void main(String[] args) {
        final SolutionSlices ss = new SolutionSlices();

        System.out.println(ss.solution(new double[]{1.0, 0.1, -1.0, -7.0, 3.0, -5.0, -2.5, 0.0, 1.0}));
    }

    /**
     * Calculates the products lists representing the amount of any slice configuration and
     * returns the maximum product value.
     *
     * @param elementsList a list of real numbers
     * @return the value of the maximum product
     */
    public double solution(double[] elementsList) {
        // write your code in Java SE 8
        final List<Double> listArray = DoubleStream.of(elementsList).boxed().collect(Collectors.toList());
        final List<Double> slicesSum = new ArrayList<>();

        /*
          Created elementsList way of iterating every possible slice of the array.
         */
        while (listArray.size() > 2) {
            final List<Double> clonedList = new ArrayList<>(listArray);
            while (clonedList.size() > 2) {
                slicesSum.addAll(getListOfProducts(clonedList));
                clonedList.remove(clonedList.size() - 1);
            }

            listArray.remove(0);
        }

        final double maxProduct = slicesSum.stream().mapToDouble(product -> product).max().orElseGet(() -> 0.0);
        return (maxProduct > MAX_ALLOWED_PRODUCT) ? MAX_ALLOWED_PRODUCT : maxProduct;
    }

    /**
     * Having a list of real numbers wil start with first element and will be
     * multiplied with every list element.
     * <p>
     * Example:
     * Having the list: {1.0, 0.3, -5.0, -7.0}
     * the result will be another list with the following elements: {1.0, 0.3, -1.5, 10.5}
     *
     * @param elementsList a list of real numbers
     * @return returning a list of products.
     */
    private List<Double> getListOfProducts(final List<Double> elementsList) {
        final List<Double> slicesSum = new ArrayList<>();
        final AtomicReference<Double> productAmount = new AtomicReference<>(1.0);

        elementsList.forEach(numberValue -> {
            final double newProductAmount = numberValue * productAmount.get();
            productAmount.set(newProductAmount);
            slicesSum.add(newProductAmount);
        });

        productAmount.set(1.0);
        return slicesSum;
    }
}
