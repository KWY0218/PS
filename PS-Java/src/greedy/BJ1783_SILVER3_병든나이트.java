package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1783_SILVER3_병든나이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 1) System.out.println("1");
        else if (n == 2) {
            System.out.println(Math.min(4, (m + 1) / 2));
        } else if (n >= 3) {
            if (m >= 7) {
                System.out.println(m - 2);
            } else {
                System.out.println(Math.min(4, m));
            }
        }
    }
}
