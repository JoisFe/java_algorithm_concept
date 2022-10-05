package othergraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 조재철
 * @since 1.0
 */
public class Kruskal {
    protected static int v;
    protected static int e;

    protected static List<Integer> parent = new ArrayList<>();
    protected static List<Edge> edges = new ArrayList<>();

    protected static int result = 0;

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
            int cost = scanner.nextInt();

            edges.add(new Edge(cost, a, b));
        }

        Collections.sort(edges);

        for (Edge edge : edges) {
            int cost = edge.getDistance();
            int a = edge.getNodeA();
            int b = edge.getNodeB();

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);

                result += cost;
            }
        }

        System.out.println(result);
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

        int parentNode = findParent(Kruskal.parent.get(a));

        Kruskal.parent.set(a, parentNode);

        return parentNode;
    }
}

class Edge implements Comparable<Edge> {
    private final int distance;
    private final int nodeA;
    private final int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.distance < o.distance) {
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
