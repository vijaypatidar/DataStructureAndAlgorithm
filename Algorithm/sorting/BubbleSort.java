import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();// array length
        int[] ar = new int[n];
        for (int i=0;i<n;i++){
            ar[i] = scanner.nextInt();
        }

        boolean change=true;
        while (change){
            change = false;
            for (int i=0;i<n-1;i++){
                if(ar[i]>ar[i+1]){
                    int tmp = ar[i];
                    ar[i] = ar[i+1];
                    ar[i+1] = tmp;
                    change = true;
                }
            }
        }

        System.out.println(Arrays.toString(ar));
    }
}
