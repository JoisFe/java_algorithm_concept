package shortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class FloydWarshall {

    protected static final int INF = (int) 1e9;

    protected static int n, m;

    protected static List<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == j) {
                    graph.get(i).add(0);

                    continue;
                }
                graph.get(i).add(INF);
            }
        }

        for (int i = 0; i < m; ++i) {
            int start = scanner.nextInt();
            int next = scanner.nextInt();
            int distance = scanner.nextInt();

            graph.get(start).set(next, distance);
        }

        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    graph.get(i).set(j, Math.min(graph.get(i).get(j), graph.get(i).get(k) + graph.get(k).get(j)));
                }
            }
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (graph.get(i).get(j) == INF) {
                    System.out.println("INFINITY ");
                } else {
                    System.out.print(graph.get(i).get(j) + " ");
                }
            }
            System.out.println();
        }
    }
}
