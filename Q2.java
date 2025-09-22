import java.util.Arrays;

public class ProcessArray {
    public static int processArray(int[] arr) {
        return Arrays.stream(arr)
                .map(n -> n * 2)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        System.out.println(processArray(numbers)); // this should print 12
    }
}
