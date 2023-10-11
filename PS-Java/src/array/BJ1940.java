package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1940 {
    /*
     * 2초 : 200,000,000
     * N : 15,000
     * NlogN : 195,000
     * N^2 : 225,000,000
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int startIdx = 0;
        int endIdx = n - 1;
        int answer = 0;
        while (startIdx < endIdx) {
            int sum = nums[startIdx] + nums[endIdx];
            if (sum < m) startIdx++;
            else if (sum > m) endIdx--;
            else {
                answer++;
                startIdx++;
                endIdx--;
            }
        }
        System.out.println(answer);
    }
}
