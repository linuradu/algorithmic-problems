package hackerrank.sorting;

import java.util.Comparator;

// Quicksort
public class ComparatorSorting implements Comparator<Player> {

    // Arrays.sort(array[], Comparator) - is using qucksort sorting method
    @Override
    public int compare(Player p1, Player p2) {
        if (p1.score == p2.score) {
            return p1.name.compareTo(p2.name);
        } else {
            if (p1.score > p2.score) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
