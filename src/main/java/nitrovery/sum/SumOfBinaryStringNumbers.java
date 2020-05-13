package nitrovery.sum;

public class SumOfBinaryStringNumbers {

    public static void main(String[] args) {
        String firstNumber = "01101011";
        String secondNumber = "10100111";

        String numbersSum = getBinaryNumbersSum(firstNumber, secondNumber);
        System.out.println(numbersSum);
        // 100010
        // 110010
        //1010100
    }

    private static String getBinaryNumbersSum(String firstNumber, String secondNumber) {
        /*
        rules for add binaries numbers
        0 + 0 = 0
        1 + 0 = 1
        1 + 1 = 0 and carry 1
        1+1+1 = 1 and carry 1
         */

        StringBuilder numbersSum = new StringBuilder();
        int firstNoIndex = firstNumber.length() - 1;
        int secondNoIndex = secondNumber.length() - 1;

        int carry = 0;
        while (firstNoIndex >= 0 || secondNoIndex >= 0) {
            int sum = 0;

            if (firstNoIndex >= 0 && firstNumber.charAt(firstNoIndex) == '1') {
                sum++;
            }

            if (secondNoIndex >= 0 && secondNumber.charAt(secondNoIndex) == '1') {
                sum++;
            }
            sum += carry;
            carry = sum > 1 ? 1 : 0;

            numbersSum.insert(0, sum % 2);

            firstNoIndex--;
            secondNoIndex--;
        }

        if (carry == 1) {
            numbersSum.insert(0, '1');
        }

        return numbersSum.toString();
    }

    private static Integer getStringDigitByIndex(String firstNumber, int firstNumberLastIndex) {
        if (firstNumberLastIndex < 0) {
            return 0;
        }

        return Character.getNumericValue(firstNumber.charAt(firstNumberLastIndex));
    }

}
