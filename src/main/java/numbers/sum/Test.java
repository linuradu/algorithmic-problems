package numbers.sum;

public class Test {
    public static void main(String a[]) {

        int arr[] = {7, 3, 10, 12, 9, 8, 2, 0};

        int sum = 12;
        String result = "";


        for (int x = 0; x < arr.length; x++) {
            for (int z = 0; z < arr.length; z++) {
                if (arr[x] + arr[z] == sum) {
                    result = "First number is: ".concat(String.valueOf(arr[x])) +
                            "  Second number is: ".concat(String.valueOf(arr[z]));
                    System.out.println(result);
                }
            }
        }

    }
}
