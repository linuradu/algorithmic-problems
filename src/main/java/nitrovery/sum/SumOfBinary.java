package nitrovery.sum;

public class SumOfBinary {

    public static void main(String[] args) {
        final String firstNumber = "1011";
        final String secondNumber = "1110";

        final String sumOfNumbers = getSumOfBinaryNumbers(firstNumber, secondNumber);
        System.out.println(sumOfNumbers);
    }

    /*
    how to calculate:
     1101+
     1110
    11011

    1+1 = 0 carrier 1
    1+0 = 1 carrier 0
    1+1+1(carrier) = 1 carrier 1
     */
    private static String getSumOfBinaryNumbers(String firstNumber, String secondNumber) {
        final StringBuilder sb = new StringBuilder();

        int firstIndex = firstNumber.length() - 1;
        int secondIndex = secondNumber.length() - 1;

        int carrier = 0;
        while (firstIndex >= 0 || secondIndex >= 0) {
            int sum = 0;

            if (firstIndex >= 0 && firstNumber.charAt(firstIndex) == '1') {
                sum++;
            }
            if (secondIndex >= 0 && secondNumber.charAt(secondIndex) == '1') {
                sum++;
            }

            sum += carrier;
            carrier = sum >= 2 ? 1 : 0;

            sb.insert(0, sum % 2);

            firstIndex--;
            secondIndex--;
        }

        if (carrier > 0) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }
}
