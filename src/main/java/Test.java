import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    static char ccc;

    class TestInner{
        private int NO_OF_CHARACTERS = 26;
    }


    public static void main(String[] args) {
        List<String> contacts = new ArrayList<>();
        contacts.add("abc");
        contacts.add("abcd");


        Map<Character, Character> map = new HashMap<>();
        map.put('a', 'a');

        Character c = map.get('j');

        String s = "abcd";
        for(int i = 1; i< s.length(); i++){
//            s.charAt(i) = '\u0000';

        }

        char parseExpression[];
//        parseExpression.length

        //System.out.println(contacts.stream().filter(contact -> contact.contains("abc")).count());

        System.out.println(ccc);
    }
}
