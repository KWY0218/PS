package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659 {
    /*
     *  시간 제한 1초 , 100,000,000
     *  100,000 * 100,000 = 10,000,000,000 (n^2) (x)
     *  100,000 log 100,000 = 1,660,000 (n log n) (o)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arrSum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arrSum[i] = arrSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int num = 0; num < m; num++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(arrSum[j] - arrSum[i - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
