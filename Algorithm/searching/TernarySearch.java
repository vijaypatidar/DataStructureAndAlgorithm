import java.util.Scanner;

public class TernarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();// array length
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        int key = scanner.nextInt();
        int res = ternarySearch(ar, key);
        if (res == -1)
            System.out.println("not found in array");
        else
            System.out.println("key found at index " + res);
    }

    private static int ternarySearch(int[] ar, int key) {
        return ternarySearch(ar, key, 0, ar.length - 1);
    }

    private static int ternarySearch(int[] ar, int key, int start, int end) {
        if (start <= end) {
            int mid1 = start + (end - start) / 3;
            int mid2 = end - (end - start) / 3;

            if (ar[mid1] == key) {
                return mid1;
            } else if (ar[mid2] == key) {
                return mid2;
            } else if (ar[mid1] > key) {
                return ternarySearch(ar, key, start, mid1 - 1);
            } else if (ar[mid2] > key) {
                return ternarySearch(ar, key, mid1 + 1, mid2 - 1);
            } else {
                return ternarySearch(ar, key, mid2 + 1, end);
            }
        }
        return -1;
    }

}
