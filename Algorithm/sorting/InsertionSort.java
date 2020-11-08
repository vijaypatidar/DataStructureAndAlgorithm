import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();// array length
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int tmp = ar[i];
            int j = i - 1;
            while (j >= 0 && tmp < ar[j]) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j+1] = tmp;
        }

        System.out.println(Arrays.toString(ar));
    }
}
