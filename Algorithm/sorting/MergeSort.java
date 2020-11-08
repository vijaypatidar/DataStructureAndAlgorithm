import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();// array length
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }

        sort(ar, 0, ar.length - 1);

        System.out.println(Arrays.toString(ar));
    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(array, start, mid);
            sort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] startArr = new int[mid - start + 1];
        int[] endArr = new int[end - mid];

        for (int i=0;i<startArr.length;i++){
            startArr[i] = array[start+i];
        }
        for (int i = 0; i < endArr.length; i++) {
            endArr[i] = array[mid + 1 + i];
        }
        int i = 0, j = 0, k = start;
        while (i < startArr.length && j < endArr.length) {
            //change <= to >= and vice versa to reverse the order
            if (startArr[i] <= endArr[j]) {
                array[k++] = startArr[i++];
            } else {
                array[k++] = endArr[j++];
            }
        }

        while (i < startArr.length) {
            array[k++] = startArr[i++];
        }
        while (j < endArr.length) {
            array[k++] = endArr[j++];
        }
    }
}
