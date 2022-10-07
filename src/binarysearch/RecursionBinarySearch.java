package binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class RecursionBinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int target = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            list.add(scanner.nextInt());
        }

        int result = binarySearch(list, target, 0, n - 1);

        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        } else {
            System.out.println(result + 1);
        }
    }

    private static int binarySearch(List<Integer> list, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (list.get(mid) == target) {
            return mid;
        } else if (list.get(mid) > target) {
            return binarySearch(list, target, start, mid -1);
        } else {
            return binarySearch(list, target, mid + 1, end);
        }
    }

}
