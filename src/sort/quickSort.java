package sort;

import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class quickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }

        quickSort(arr, 0, n - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;

        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot]) {
                ++left;
            }

            while (right > start && arr[right] >= arr[pivot]) {
                --right;
            }

            if (left > right) {
                int tmp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = tmp;
            } else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

}
