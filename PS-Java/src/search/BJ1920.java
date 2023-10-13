package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = n;
            boolean isExited = false;
            while (start < end) {
                int mid = (start + end) / 2;
                if (nums[mid] > target) {
                    end = mid;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    isExited = true;
                    break;
                }
            }
            if (isExited) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }
}
