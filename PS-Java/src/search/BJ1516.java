package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] nums = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
            parent[i] = st.countTokens() - 1;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num != -1) graph.get(num).add(i);
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (parent[i] == 0) que.add(i);
        }
        int[] answer = new int[n + 1];
        while (!que.isEmpty()) {
            int q = que.poll();
            List<Integer> child = graph.get(q);
            for (int c : child) {
                answer[c] = Math.max(answer[c], answer[q] + nums[q]);
                parent[c]--;
                if (parent[c] == 0) que.add(c);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(nums[i] + answer[i]);
        }
    }
}
