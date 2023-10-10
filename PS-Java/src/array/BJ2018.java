package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2018 {
    /*
     * 2초 : 200,000,000
     * N : 10,000,000 (o)
     * NlogN : 230,000,000 (x)
     * N^2 : 100,000,000,000,000 (x)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sIdx = 1;
        int eIdx = 1;
        int count = 1;
        int sum = 1;

        while (eIdx < n) {
            if (sum < n) {
                eIdx++;
                sum += eIdx;
            } else if (sum > n) {
                sum -= sIdx;
                sIdx++;
            } else {
                count++;
                eIdx++;
                sum += eIdx;
            }
        }
        System.out.println(count);
    }
}
