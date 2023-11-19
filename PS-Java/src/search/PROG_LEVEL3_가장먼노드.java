package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PROG_LEVEL3_가장먼노드 {
    class Solution {
        public int solution(int n, int[][] edge) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] site : edge) {
                graph.get(site[0]).add(site[1]);
                graph.get(site[1]).add(site[0]);
            }

            PriorityQueue<Node> nodes = new PriorityQueue<>();
            boolean[] visited = new boolean[n + 1];
            Queue<Node> que = new LinkedList<>();


            que.add(new Node(1, 1));
            visited[1] = true;
            while (!que.isEmpty()) {
                Node node = que.poll();
                for (int num : graph.get(node.next)) {
                    if (!visited[num]) {
                        visited[num] = true;
                        nodes.add(new Node(num, node.deps + 1));
                        que.add(new Node(num, node.deps + 1));
                    }
                }
            }
            int max = nodes.peek().deps;
            int answer = 0;
            while (!nodes.isEmpty()) {
                Node node = nodes.poll();
                if (max == node.deps) answer++;
                else break;
            }
            return answer;
        }
    }

    class Node implements Comparable<Node> {
        int next;
        int deps;

        Node(int next, int deps) {
            this.next = next;
            this.deps = deps;
        }

        @Override
        public int compareTo(Node o) {
            return o.deps - this.deps;
        }
    }

}
