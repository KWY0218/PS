package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] strs = str.split("-");
        Deque<Integer> list = new LinkedList<>();
        for (String s : strs) {
            if (!s.contains("+")) {
                list.add(Integer.parseInt(s));
                continue;
            }
            int sum = Arrays.stream(s.split("\\+")).mapToInt(Integer::parseInt).sum();
            list.add(sum);
        }
        int answer = list.pollFirst();
        while (!list.isEmpty()) {
            answer -= list.pollFirst();
        }
        System.out.println(answer);
    }
}
