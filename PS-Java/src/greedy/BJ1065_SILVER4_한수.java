package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1065_SILVER4_한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if (num < 100) System.out.println(num);
        else {
            int answer = 99;
            for (int i = 100; i <= num; i++) {
                int[] nums = Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
                int del = nums[1] - nums[0];
                boolean isAns = true;
                for (int n = 2; n < nums.length; n++) {
                    int d = nums[n] - nums[n - 1];
                    if (d == del) continue;
                    isAns = false;
                    break;
                }
                if (isAns) answer++;
            }
            System.out.println(answer);
        }
    }
}
