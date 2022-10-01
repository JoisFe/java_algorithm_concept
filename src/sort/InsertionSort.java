package sort;

import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class InsertionSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 1; i < n; ++i) {
            for (int j = i; j > 0; --j) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }

                else break;
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
