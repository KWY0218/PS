package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            nums[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (nums[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int q = queue.poll();
            sb.append(q).append(" ");
            for (int next : graph.get(q)) {
                if (--nums[next] == 0) queue.add(next);
            }
        }

        System.out.println(sb);
    }
}
