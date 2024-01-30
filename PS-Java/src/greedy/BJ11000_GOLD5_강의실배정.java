package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11000_GOLD5_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Time2[] times = new Time2[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = new Time2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(times);
        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.add(times[0].end);
        for (int i = 1; i < n; i++) {
            if (que.peek() <= times[i].start) {
                que.poll();
                que.add(times[i].end);
                continue;
            }
            que.add(times[i].end);
        }

        System.out.println(que.size());
    }
}

class Time2 implements Comparable<Time> {
    int start;
    int end;

    public Time2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.start == o.start) return this.end - o.end;
        return this.start - o.start;
    }
}
