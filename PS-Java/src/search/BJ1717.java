package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717 {
    private static int[] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        group = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            group[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (c == 0) {
                union(a, b);
            } else {
                int aHead = find(a);
                int bHead = find(b);
                if (aHead == bHead) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int aHead = find(a);
        int bHead = find(b);
        if (aHead != bHead) {
            if (aHead < bHead) {
                group[bHead] = aHead;
            } else {
                group[aHead] = bHead;
            }
        }
    }

    private static int find(int num) {
        if (group[num] != num) {
            group[num] = find(group[num]);
        }
        return group[num];
    }
}
