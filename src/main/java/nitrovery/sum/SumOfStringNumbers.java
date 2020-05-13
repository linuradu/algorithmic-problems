package nitrovery.sum;

public class SumOfStringNumbers {

    public static void main(String[] args) {
        String firstNumber = "12345";
        String secondNumber = "12345";

        String numbersSum = getBinaryNumbersSum(firstNumber, secondNumber);
        System.out.println(numbersSum);

        System.out.println(12345 + 12345);
    }

    private static String getBinaryNumbersSum(String firstNumber, String secondNumber) {
        StringBuilder numbersSum = new StringBuilder();
        int firstNumberLastIndex = firstNumber.length() - 1;
        int secondNumberLastIndex = secondNumber.length() - 1;

        int carry = 0;
        while (firstNumberLastIndex >= 0 || secondNumberLastIndex >= 0) {
            Integer sum = getStringDigitByIndex(firstNumber, firstNumberLastIndex) + getStringDigitByIndex(secondNumber, secondNumberLastIndex) + carry;

            if (sum > 9) {
                String sumString = sum.toString();
                numbersSum.append(sumString.charAt(1));

                carry = Character.getNumericValue(sumString.charAt(0));
            } else {
                numbersSum.append(sum.toString());
                carry = 0;
            }


            firstNumberLastIndex--;
            secondNumberLastIndex--;
        }

        if (carry > 0) {
            numbersSum.append(carry);
        }

        return numbersSum.reverse().toString();
    }

    private static Integer getStringDigitByIndex(String firstNumber, int firstNumberLastIndex) {
        if (firstNumberLastIndex < 0) {
            return 0;
        }

        return Character.getNumericValue(firstNumber.charAt(firstNumberLastIndex));
    }

}
