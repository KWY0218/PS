package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] min = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        int k = Integer.parseInt(br.readLine());
        min[k] = 0;

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(k, 0));
        boolean[] visited = new boolean[v + 1];
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            if (visited[currNode.index]) continue;

            visited[currNode.index] = true;
            for (Node node : graph.get(currNode.index)) {
                int weight = node.weight;
                int index = node.index;
                int currWeight = currNode.weight + weight;
                if (currWeight < min[index]) {
                    min[index] = currWeight;
                    queue.add(new Node(index, currWeight));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (visited[i]) {
                sb.append(min[i]).append("\n");
            } else {
                sb.append("INF\n");
            }
        }
        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        if (this.weight > o.weight) return 1;
        else return -1;
    }
}
