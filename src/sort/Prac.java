package sort;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Prac {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort2(arr, 0, n - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort2(int[] arr, int start, int end) {
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
                int tmp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = tmp;
            } else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        quickSort2(arr, start, right - 1);
        quickSort2(arr, right + 1, end);
    }
}
