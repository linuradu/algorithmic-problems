package comparestrings;

public class TestsStrings {

    public static void main(String[] args) {
        String one = "The boolean argument indicates whether case should be ignored; if true, case is ignored when comparing characters.";
        String two = "The boolean argument indicates whether case should be ignored; if true, case is ignored when comparing characters.";

        Boolean areEqual = one.regionMatches(0, two, 0, 30);

        System.out.println(areEqual);
    }
}
