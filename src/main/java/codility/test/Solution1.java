package codility.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution1 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, -1, 5, 4, 1, 2}));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        final List<Integer> listArray = IntStream.of(A).sorted().boxed().collect(Collectors.toList());

        if (listArray.get(listArray.size() - 1) < 0) {
            return 1;
        }

        // if



        // if the difference between two numbers is less than
        for (int i = 0; i < listArray.size() - 1; i++) {
            if (Math.abs(listArray.get(i+1) - listArray.get(i)) > 1){
                int value = listArray.get(i);
                while(value < listArray.get(i+1) ){
                    if(++value > 0 && value != listArray.get(i+1))
                        return value;
                }
            }
        }

//        listArray.forEach();


        return listArray.get(listArray.size() - 1) + 1;


    }
}
