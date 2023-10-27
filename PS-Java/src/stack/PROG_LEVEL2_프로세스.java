package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class PROG_LEVEL2_프로세스 {
    public static void main(String[] args) {
        int[] properties = {2, 1, 3, 2};
        solution(properties, 2);

        int[] properties2 = {1, 1, 9, 1, 1, 1};
        solution(properties2, 0);
    }

    public static int solution(int[] priorities, int location) {
        Deque<Process> processes = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            processes.add(new Process(i, priorities[i]));
        }


        Arrays.sort(priorities);
        // 역순으로 정렬
        int[] prioritiesReverse = IntStream.range(0, priorities.length)
                .mapToObj(i -> priorities[priorities.length - 1 - i])
                .mapToInt(Integer::intValue)
                .toArray();

        int answer = 0;
        while (!processes.isEmpty()) {
            Process process = processes.pollFirst();
            if (prioritiesReverse[answer] != process.priority) {
                processes.addLast(process);
                continue;
            }
            if (location == process.index) return answer + 1;
            answer++;
        }

        return answer + 1;
    }
}

class Process {
    int index;
    int priority;

    public Process(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
