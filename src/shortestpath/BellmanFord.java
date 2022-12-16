package shortestpath;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class BellmanFord {

    public static final int INF = (int) 1e9;
    public static int n;
    public static int m;
    public static int start;

    public static Edge[] edges;
    public static long[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        edges = new Edge[m + 1];
        dist = new long[n + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i < m; ++i) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            int distance = sc.nextInt();

            edges[i] = new Edge(startNode, endNode, distance);
        }

        dist[start] = 0;
        bellmanFord(start);

        boolean negativeCycle = false;

        for (int i = 0; i < m; ++i) {
            Edge edge = edges[i];
            if (dist[edge.getStartNode()] != INF
                && dist[edge.getEndNode()] > dist[edge.getStartNode()] + edge.getDistance()) {
                negativeCycle = true;

                break;
            }
        }

        if (negativeCycle) {
            System.out.println("-1");
            return;
        }

        for (int i = 2; i <= n; ++i) {
            if (dist[i] == INF) {
                System.out.println("-1");

                continue;
            }

            System.out.println(dist[i]);
        }
    }

    private static void bellmanFord(int node) {
        dist[node] = 0;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                Edge edge = edges[j];

                if (dist[edge.getStartNode()] != INF
                    && dist[edge.getEndNode()] > dist[edge.getStartNode()] + edge.getDistance()) {
                    dist[edge.getEndNode()] = dist[edge.getStartNode()] + edge.getDistance();
                }
            }
        }
    }
}

class Edge {

    private final int startNode;
    private final int endNode;
    private final int distance;

    public Edge(int startNode, int endNode, int distance) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.distance = distance;
    }

    public int getStartNode() {
        return startNode;
    }

    public int getEndNode() {
        return this.endNode;
    }

    public int getDistance() {
        return this.distance;
    }
}