package sort;

import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < n; ++j) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
