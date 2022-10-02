package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Prac {

    protected static final List<ArrayList<Integer>> graph = new ArrayList<>();
    protected static final List<Boolean> visited = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodeSize = scanner.nextInt();
        int edgeSize = scanner.nextInt();

        for (int i = 0; i <= nodeSize; ++i) {
            graph.add(new ArrayList<>());

            visited.add(false);
        }

        for (int i = 0; i < edgeSize; ++i) {
            int startNode = scanner.nextInt();
            int endNode = scanner.nextInt();

            graph.get(startNode).add(endNode);
        }

        bfs2(1);
    }

    private static void bfs2(int startNode) {
        System.out.println(startNode + " ");

        visited.set(startNode, true);

        for (int i = 0; i < graph.get(startNode).size(); ++i) {
            int nextNode = graph.get(startNode).get(i);

            if (Boolean.FALSE.equals(visited.get(nextNode))) {
                bfs2(nextNode);
            }
        }
    }

}
