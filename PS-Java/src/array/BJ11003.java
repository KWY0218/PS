package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Node> deque = new LinkedList<>();
        int leftIdx = 1 - l;
        for (int rightIdx = 0; rightIdx < n; rightIdx++) {
            // 뒤에서부터 최소 값을 분류한다.
            while (!deque.isEmpty() && deque.getLast().value > nums[rightIdx]) {
                deque.pollLast();
            }

            // 현재 값을 뒤에 추가한다.
            deque.addLast(new Node(rightIdx, nums[rightIdx]));

            // 출력 값을 추가한다.
            sb.append(deque.getFirst().value).append(" ");

            // 왼쪽 index 와 현재 앞에 있는 index 가 같다면 제거한다.
            if (deque.getFirst().index == leftIdx) deque.pollFirst();
            leftIdx++;
        }

        System.out.println(sb);
    }
}

class Node {
    int index;
    int value;

    Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
