import java.util.*;

public class Checker implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    public static void main(String[] args) {
//        Set<Checker> map = new TreeSet<>();
//        map.add(new Checker());

        List<Checker> authors = new ArrayList<>();

        Checker[] authorsArray = new  Checker[10];

        Collections.sort(authors, new Checker().reversed());
        Arrays.sort(authorsArray, new Checker());
    }


}
