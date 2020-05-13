
//import javafx.scene.layout.Priority;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestDouble {

    public static void main(String[] args) {
        System.out.println(getDoubleNumber());

        System.out.println(getIntNumber());

        PriorityQueue aa;

        Comparator.reverseOrder();
    }

    public static double getDoubleNumber() {
        Integer a = 1;

        return ((double) a + a) / 2; // here should be used the cast because is possible the result have space in a INT and the result will be truncated
    }

    public static int getIntNumber() {
        double a = 1.0;

        return (int) (a + a / 2);
    }
}
