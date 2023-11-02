package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PROG_LEVEL3_이중우선순위큐 {
    public int[] solution(String[] operations) {
        List<Integer> temp = new ArrayList<>();
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String o = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (o.equals("I")) {
                temp.add(value);
                continue;
            }

            if (temp.isEmpty()) continue;

            if (value == 1) {
                que = new PriorityQueue<>(Comparator.reverseOrder());
            } else if (value == -1) {
                que = new PriorityQueue<>();
            }
            que.addAll(temp);
            que.poll();

            temp.clear();
            temp.addAll(que);
        }

        int[] answer = {0, 0};
        if (temp.isEmpty()) return answer;

        que = new PriorityQueue<>(Comparator.reverseOrder());
        que.addAll(temp);
        answer[0] = que.peek();

        que = new PriorityQueue<>();
        que.addAll(temp);
        answer[1] = que.peek();

        return answer;
    }
}
