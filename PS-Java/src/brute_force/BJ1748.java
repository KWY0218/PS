package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class BJ1748 {
    public void OTHER() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int answer = 0;

        for (int i = 1; i <= n; i *= 10) {
            int len = String.valueOf(i).length();

            if (n <= i * 10 - 1) {
                answer += (n - i + 1) * len;
            } else {
                answer += (10 * i - i) * len;
            }

        }

        System.out.println(answer);
    }

    public void KWY() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());

        int count = 1;
        int ten = 1;
        int num = n;
        while (num / 10 != 0) {
            count++;
            ten *= 10;
            num /= 10;
        }

        int answer = 0;
        answer += (n - ten + 1) * count--;
        while (count > 0) {
            answer += (ten - ten / 10) * count--;
            ten /= 10;
        }
        System.out.println(answer);
    }
}
