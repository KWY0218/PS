package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5212_SILVER2_지구온난화 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[][] map = new String[r][];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().split("");
        }

        String[][] after = new String[r][c];
        int[][] site = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minX = 10;
        int maxX = 0;
        int minY = 10;
        int maxY = 0;
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                if (!map[x][y].equals("X")) {
                    after[x][y] = ".";
                    continue;
                }

                int count = 0;
                for (int[] s : site) {
                    int nextX = x + s[0];
                    int nextY = y + s[1];
                    if (nextX >= r || nextY >= c || nextX < 0 || nextY < 0) {
                        count++;
                        continue;
                    }
                    if (map[nextX][nextY].equals(".")) count++;
                }
                if (count > 2) after[x][y] = ".";
                else {
                    after[x][y] = "X";
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                sb.append(after[x][y]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
