package stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PROG_LEVEL2_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] a1 = solution(progresses, speeds);

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] a2 = solution(progresses2, speeds2);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            queue.add(getRest(progress, speed));
        }

        int day = 1;
        while (!queue.isEmpty()) {
            if (day < queue.peek()) {
                day++;
                continue;
            }

            int ans = 0;
            while (!queue.isEmpty() && day >= queue.peek()) {
                ans++;
                queue.poll();
            }
            answer.add(ans);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getRest(int p, int s) {
        int restProgress = 100 - p;
        int count = restProgress / s;
        if (restProgress % s != 0) count++;
        return count;
    }
}
