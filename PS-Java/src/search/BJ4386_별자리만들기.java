package search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ4386_별자리만들기 {

    private static int[] parent;

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Site> sites = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            sites.add(new Site(x, y));
        }

        PriorityQueue<Edge4386> graph = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dx = sites.get(i).x - sites.get(j).x;
                double dy = sites.get(i).y - sites.get(j).y;
                double weight = Math.sqrt(dy * dy + dx * dx);
                graph.add(new Edge4386(i, j, weight));
            }
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        double answer = 0;
        while (!graph.isEmpty()) {
            Edge4386 edge = graph.poll();
            if (union(edge.index, edge.next)) answer += edge.weight;
        }

        System.out.printf("%.2f%n", answer);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        if (a > b) parent[a] = b;
        else parent[b] = a;

        return true;
    }

    private static int find(int a) {
        if (a != parent[a]) {
            parent[a] = find(parent[a]);
        }
        return parent[a];

    }

}

class Edge4386 implements Comparable<Edge> {
    int index;
    int next;
    double weight;

    public Edge4386(int index, int next, double weight) {
        this.index = index;
        this.next = next;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return (int) (this.weight - o.weight);
    }
}

class Site {
    double x;
    double y;

    public Site(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
