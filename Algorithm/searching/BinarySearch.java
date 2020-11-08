import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();// array length
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        int key = scanner.nextInt();
        int res = binarySearch(ar, key);
        if (res == -1)
            System.out.println("not found in array");
        else
            System.out.println("key found at index " + res);
    }

    private static int binarySearch(int[] ar, int key) {
        return binarySearch(ar, key, 0, ar.length - 1);
    }

    private static int binarySearch(int[] ar, int key, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            if (ar[mid] == key) {
                return mid;
            } else if (ar[mid] < key) {
                return binarySearch(ar, key, mid + 1, end);
            } else {
                return binarySearch(ar, key, start, mid - 1);
            }
        }
        return -1;
    }

}
