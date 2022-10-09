package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class CountingSort {

    public static final int MAX_VALUE = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        System.out.println("10,000 보다 작은수만 입력해주세용");

        for (int i = 0; i < n; ++i) {
            list.add(scanner.nextInt());
        }

        List<Integer> cnt = new ArrayList<>();

        for (int i = 0; i <= MAX_VALUE; ++i) {
            cnt.add(0);
        }

        for (int i = 0; i < n; ++i) {
            cnt.set(list.get(i), cnt.get(list.get(i)) + 1);
        }

        for (int i = 0; i <= MAX_VALUE; ++i) {
            for (int j = 0; j < cnt.get(i); ++j) {
                System.out.print(i + " ");
            }
        }

    }

}
