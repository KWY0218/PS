package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ1744 {
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusNums = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusNums = new PriorityQueue<>();
        int oneNums = 0;
        boolean isZero = false;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0) minusNums.add(num);
            else if (num == 1) oneNums += 1;
            else if (num > 0) plusNums.add(num);
            else isZero = true;
        }

        calculate(plusNums);
        if (plusNums.size() == 1) answer += plusNums.remove();
        if (!minusNums.isEmpty()) calculate(minusNums);

        if (!minusNums.isEmpty() && !isZero) answer += minusNums.remove();

        System.out.println(answer + oneNums);
    }

    private static void calculate(PriorityQueue<Integer> nums) {
        while (nums.size() > 1) {
            int num1 = nums.remove();
            int num2 = nums.remove();
            answer += (num1 * num2);
        }
    }
}
