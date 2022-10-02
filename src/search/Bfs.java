package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Bfs {

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

        bfs(1);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        visited.set(start, true);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            System.out.println(currentNode + " ");

            for (int i = 0; i < graph.get(currentNode).size(); ++i) {
                int nextNode = graph.get(currentNode).get(i);

                if (Boolean.FALSE.equals(visited.get(nextNode))) {
                    queue.offer(nextNode);
                    visited.set(nextNode, true);
                }
            }
        }
    }

}
