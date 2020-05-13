package codility;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SolutionPairs {

    private static final int MAX_PAIRS_NO = 1_000_000_000;

    public static void main(String[] args) {
        final SolutionPairs s = new SolutionPairs();

        System.out.println(s.solution(new int[]{3, 5, 6, 3, 3, 5}));
    }

    public int solution(int[] a) {
        final List<Integer> listArray = IntStream.of(a).sorted().boxed().collect(Collectors.toList());
        final Map<Integer, Long> identicalElementsCount = listArray.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final Integer identicalPairs = identicalElementsCount.values().stream()
                .map(Long::intValue)
                .filter(SolutionPairs::isPositiveValue)
                .map(this::getNoOfPairs)
                .reduce(Integer::sum).orElseGet(() -> 0);
        return (identicalPairs > MAX_PAIRS_NO) ? MAX_PAIRS_NO : identicalPairs;
    }

    private static boolean isPositiveValue(final Integer number) {
        return number > 1;
    }

    private int getNoOfPairs(final Integer number) {
        return IntStream.range(0, number)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
