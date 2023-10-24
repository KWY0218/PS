package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BJ1197_최소스패닝트리 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Edge> graph = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Edge(a, b, c));
        }
        graph = graph.stream().sorted().collect(Collectors.toList());

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        int answer = 0;
        for (Edge edge : graph) {
            if (union(edge.index, edge.next)) answer += edge.weight;
        }
        System.out.println(answer);
    }

    private static boolean union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent == bParent) return false;

        if (aParent > bParent) parent[aParent] = bParent;
        else parent[bParent] = aParent;

        return true;
    }

    private static int find(int child) {
        if (parent[child] != child) {
            parent[child] = find(parent[child]);
        }
        return parent[child];
    }
}

class Edge implements Comparable<Edge> {
    int index;
    int next;
    int weight;

    public Edge(int index, int next, int weight) {
        this.index = index;
        this.next = next;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
