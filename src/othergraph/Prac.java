package othergraph;

import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Prac {

    protected static int v;
    protected static int e;

    protected static int[] parent = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        v = scanner.nextInt();
        e = scanner.nextInt();

        for (int i = 1 ; i <= v; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < e; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            unionParent2(a, b);
        }

        System.out.println("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; ++i) {
            System.out.print(findParent2(i) + " ");
        }
        System.out.println();

        System.out.println("부모 테이블: ");
        for (int i = 1; i <= v; ++i) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    private static void unionParent2(int a, int b) {
        a = findParent2(a);
        b = findParent2(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static int findParent2(int a) {
        if (parent[a] == a) {
            return a;
        }
        parent[a] = findParent2(parent[a]);
        return parent[a];
    }

}
