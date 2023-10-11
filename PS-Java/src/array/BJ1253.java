package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1253 {
    private static int n;
    private static long[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isGood(i, nums[i])) answer++;
        }
        System.out.println(answer);
    }

    private static boolean isGood(int currIdx, long m) {
        int startIdx = 0;
        int endIdx = n - 1;
        while (startIdx < endIdx) {
            long sum = nums[startIdx] + nums[endIdx];
            if (sum < m) startIdx++;
            else if (sum > m) endIdx--;
            else {
                if (startIdx != currIdx && endIdx != currIdx) return true;
                else if (startIdx == currIdx) startIdx++;
                else if (endIdx == currIdx) endIdx--;
            }
        }
        return false;
    }
}
