import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();// array length
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (ar[i] > max) {
                max = ar[i];
            }
        }

        int[] aux = new int[max + 1];
        for (int i = 0; i < n; i++) {
            aux[ar[i]]++;
        }

        int start = 0;
        int i = 0;
        while (i < aux.length) {
            while (aux[i] > 0) {
                ar[start] = i;
                aux[i]--;
                start++;
            }
            i++;
        }

        System.out.println(Arrays.toString(ar));
    }
}
