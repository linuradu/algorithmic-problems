package nitrovery;

public class TestsStringBuilder {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcd");

        sb.insert(2, "H");
        sb.append("1");
        System.out.println(sb.toString());
    }
}
