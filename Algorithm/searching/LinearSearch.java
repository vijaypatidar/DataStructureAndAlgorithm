import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();// array length
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        int key = scanner.nextInt();
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (key == ar[i]) {
                res = i;
                break;
            }
        }
        if (res == -1)
            System.out.println("not found in array");
        else
            System.out.println("key found at index " + res);
    }
}
