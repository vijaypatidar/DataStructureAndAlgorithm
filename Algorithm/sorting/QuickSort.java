import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();// array length
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }

        long startTime = System.currentTimeMillis();

        sort(ar, 0, ar.length - 1);

        long endTime = System.currentTimeMillis();

        System.out.println(Arrays.toString(ar));

        System.out.println((endTime - startTime) + "ms taken to sort the array.");
    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int mid = partition(array, start, end);
            sort(array, start, mid - 1);
            sort(array, mid + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int i = start + 1;
        int piv = array[start];//making the first element as pivot element.
        for (int j = start + 1; j <= end; j++) {
            /*rearrange the array by putting elements which are less than pivot
            on one side and which are greater that on other. */
            if (array[j] < piv) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i += 1;
            }
        }
        i--;
        array[start] = array[i];
        array[i] = piv;
        return i;
    }
}
