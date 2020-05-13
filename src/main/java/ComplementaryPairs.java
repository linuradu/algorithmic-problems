import java.util.*;

public class ComplementaryPairs {


    /*
    The complexity of this algorithm is O(N)
     */
    public void printComplementaryPairs(int numbers[], int k) {
        Map<Integer, Integer> map = new HashMap<>();

        /* We are going thorough the array for the first time and store in a Map the difference of the wanted sum(K) and the current element
        mapped to "how many times it occurred".
        More easily, this number represent the number we are missing for an element at a given index in order the sum(K) can be reached.
         */
        for (int i = 0; i < numbers.length; i++) {
            map.merge(k - numbers[i], 1, Integer::sum);
        }

        /*
        Going through the array a second time and check if the map contains this element. If was found, then it means that uor map contains an element "b" for which
         b = k - numbers[i], so it means that we have found a matching pair. The number of matching pair we found (matchingTimes), represent the times this element appear
         is the array.
         */
        Arrays.stream(numbers).forEach(element -> {

                    int matchingTimes = map.getOrDefault(element, 0);
                    if (matchingTimes != 0) {
                        System.out.println(matchingTimes + " time(s) " + element + " : " + (k - element));
                    }
                }
        );

        Set<Integer> visitedNodes = new HashSet<>();

        List<String> contacts = new ArrayList<>();
        contacts.stream().filter(contact -> contact.contains("")).count();
    }

    /*
    Added a testing example
     */
    public static void main(String[] args) {
        int[] testNumbers = new int[]{3, 2, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, -2, -3, -1, -5};
        int k = 1;
        new ComplementaryPairs().printComplementaryPairs(testNumbers, k);
    }
}
