package othergraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class UnionFind {
    protected static int v;
    protected static int e;
    protected static List<Integer> parent = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        v = scanner.nextInt();
        e = scanner.nextInt();

        for (int i = 0; i <= v; ++i) {
            parent.add(i);
        }

        for (int i = 0; i < e; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            unionParent(a, b);
        }

        System.out.println("각 원소가 속한 집합: ");

        for (int i = 1; i <= v; ++i) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        System.out.println("부모 테이블: ");

        for (int i = 1; i <= v; ++i) {
            System.out.print(parent.get(i) + " ");
        }
        System.out.println();
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent.set(b, a);
        } else {
            parent.set(a, b);
        }

    }

    private static int findParent(int a) {
        if (a == parent.get(a)) {
            return a;
        }

        int parentNum = findParent(UnionFind.parent.get(a));
        UnionFind.parent.set(a, parentNum);

        return parentNum;
    }
}
