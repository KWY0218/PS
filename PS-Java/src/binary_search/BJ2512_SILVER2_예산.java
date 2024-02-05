package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2512_SILVER2_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        int minNum = 0;
        int maxNum = nums[n - 1];
        while (minNum <= maxNum) {
            int mid = (minNum + maxNum) / 2;

            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp += Math.min(mid, nums[i]);
            }
            if (temp <= target) minNum = mid + 1;
            else maxNum = mid - 1;
        }
        System.out.println(maxNum);
    }
}
