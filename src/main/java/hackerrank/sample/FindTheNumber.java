package hackerrank.sample;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindTheNumber {

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
//        System.out.println(arr.stream().filter(i -> i == 6).findAny().map(i -> "YES").orElse("NO"));

        int l = 2;
        int r = 50;

        final List<Integer> oddNumbers = IntStream.range(l, r + 1).filter(i -> (i&1) != 0).boxed().collect(Collectors.toList());

        System.out.println(oddNumbers);
    }

//    public static boolean isOddNumber(final Integer number){
//
//    }
}
