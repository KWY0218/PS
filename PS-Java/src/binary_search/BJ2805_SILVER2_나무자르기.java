package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805_SILVER2_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int minNum = 0;
        int maxNum = nums[n - 1];
        while (minNum < maxNum - 1) {
            int mid = (minNum + maxNum) / 2;
            long temp = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > mid) temp += (nums[i] - mid);
            }
            if (temp >= m) minNum = mid;
            else maxNum = mid;
        }
        System.out.println(minNum);
    }
}
