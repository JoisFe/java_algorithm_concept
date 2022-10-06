package othergraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class TopologySort {

    protected static int v;
    protected static int e;

    protected static List<Integer> indegree = new ArrayList<>();
    protected static List<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        v = scanner.nextInt();
        e = scanner.nextInt();

        for (int i = 0; i <= v; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; ++i) {
            indegree.add(0);
        }

        for (int i = 0; i < e; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph.get(a).add(b);

            indegree.set(b, indegree.get(b) + 1);
        }

        topologySort();
    }

    private static void topologySort() {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; ++i) {
            if (indegree.get(i) == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int i = 0; i < graph.get(now).size(); ++i) {
                indegree.set(graph.get(now).get(i), indegree.get(graph.get(now).get(i)) - 1);

                if (indegree.get(graph.get(now).get(i)) == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

}
