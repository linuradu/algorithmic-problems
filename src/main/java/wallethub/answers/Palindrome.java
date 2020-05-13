package wallethub.answers;

public class Palindrome {

    private static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;
        int half = right / 2;

        //We are reading the character from left and right simultaneously, then compare if the value is the same.
        for (int i = 0; i < half; i++, left++, right--) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String... args) {
        String[] words = new String[]{"hello", "aba", "level", "abcd", "dish", "tenet", "run", "stats"};

        for (String word : words) {
            System.out.printf("%s : %b \n", word, isPalindrome(word));
        }
    }
}
