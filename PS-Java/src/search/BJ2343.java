package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2343 {
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

        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > start) start = nums[i];
            end += nums[i];
        }

        while (start < end) {
            int mid = (start + end) / 2;
            int count = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += nums[i];
            }
            if (sum != 0) count++;

            if (count <= m) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
}
