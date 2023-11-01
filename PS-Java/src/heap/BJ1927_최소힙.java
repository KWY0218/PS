package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PQ pq = new PQ();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(pq.pop()).append("\n");
                continue;
            }

            pq.add(num);
        }

        System.out.println(sb);
    }
}

class PQ {
    int size;
    int[] item;

    PQ() {
        this.size = 0;
        this.item = new int[100005];
    }

    public void add(int n) {
        item[++size] = n;
        int idx = size;
        while (idx != 1) {
            int parent = idx / 2;
            if (item[parent] <= item[idx]) break;

            int temp = item[parent];
            item[parent] = item[idx];
            item[idx] = temp;

            idx = parent;
        }
    }

    public int pop() {
        if (size == 0) return 0;
        int answer = item[1];
        item[1] = item[size--];

        int idx = 1;
        while (2 * idx <= size) {
            int left = 2 * idx;
            int right = 2 * idx + 1;

            int child = left;
            if (right <= size && item[left] > item[right]) child = right;

            if (item[idx] <= item[child]) break;

            int temp = item[idx];
            item[idx] = item[child];
            item[child] = temp;

            idx = child;
        }

        return answer;
    }
}
