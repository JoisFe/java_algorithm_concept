package shortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Prac {

    public static final int INF = (int) 1e9;
    protected static int n;
    protected static int m;
    protected static int start;

    protected static List<ArrayList<Node2>> graph = new ArrayList<>();
    protected static List<Integer> distanced = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        start = scanner.nextInt();

        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            int startNode = scanner.nextInt();
            int nextNode = scanner.nextInt();
            int distance = scanner.nextInt();

            graph.get(startNode).add(new Node2(nextNode, distance));
        }

        for (int i = 0; i <= n; ++i) {
            distanced.add(INF);
        }

        dijkstra2(start);


    }

    private static void dijkstra2(int start) {
        Queue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        distanced.set(start, 0);

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int dist = node.getDistance();
            int currentNode = node.getIndex();

            if (distanced.get(currentNode) < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(currentNode).size(); ++i) {
                int cost = distanced.get(currentNode) + graph.get(currentNode).get(i).getDistance();

                if (cost < distanced.get(graph.get(currentNode).get(i).getIndex())) {
                    distanced.set(graph.get(currentNode).get(i).getIndex(), cost);

                    pq.offer(new Node(graph.get(currentNode).get(i).getIndex(), cost));


                }
            }
        }

    }

}

class Node2 implements Comparable<Node2> {
    private final int index;
    private final int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node2 otherNode) {
        if (this.distance < otherNode.distance) {
            return -1;
        }

        return 1;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
