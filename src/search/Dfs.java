package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Dfs {

    public static int nodeSize;
    public static int edgeSize;

    public static List<ArrayList<Integer>> graph = new ArrayList<>(nodeSize + 1);
    public static List<Boolean> visited = new ArrayList<>(nodeSize + 1);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        nodeSize = scanner.nextInt();
        edgeSize = scanner.nextInt();


        for (int i = 0; i <= nodeSize; ++i) {
            graph.add(new ArrayList<>());

            visited.add(false);
        }

        for (int i = 1; i <= edgeSize; ++i) {
            int startNode = scanner.nextInt();
            int endNode = scanner.nextInt();

            graph.get(startNode).add(endNode);
        }

        dfs(1);
    }

    private static void dfs(int start) {
        visited.set(start, true);

        System.out.println(start + " ");

        for (int i = 0; i < graph.get(start).size(); ++i) {
            int nextNode = graph.get(start).get(i);

            if (!visited.get(nextNode)) {
                dfs(nextNode);
            }
        }
    }

}
