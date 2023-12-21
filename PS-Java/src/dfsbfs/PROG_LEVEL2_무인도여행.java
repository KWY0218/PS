package dfsbfs;

import java.util.Arrays;
import java.util.Stack;

public class PROG_LEVEL2_무인도여행 {
    class Solution {
        String[][] m;
        boolean[][] visited;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int row;
        int col;

        public int[] solution(String[] maps) {
            Stack<Integer> answer = new Stack<>();
            row = maps.length;
            col = maps[0].length();
            m = new String[row][];
            visited = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                m[i] = maps[i].split("");
            }

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (m[r][c].equals("X") || visited[r][c]) continue;
                    answer.add(getScore(r, c));
                }
            }

            if (answer.isEmpty()) return new int[]{-1};

            int[] ans = new int[answer.size()];
            for (int i = 0; i < answer.size(); i++) {
                ans[i] = answer.get(i);
            }
            Arrays.sort(ans);
            return ans;
        }

        public int getScore(int r, int c) {
            int score = 0;
            Stack<Site> stack = new Stack<>();
            stack.add(new Site(r, c));
            visited[r][c] = true;
            score += Integer.parseInt(m[r][c]);

            while (!stack.isEmpty()) {
                Site site = stack.pop();
                for (int[] d : dir) {
                    int nextR = site.x + d[0];
                    int nextC = site.y + d[1];

                    if (nextR > -1 && nextR < row && nextC > -1 && nextC < col && !m[nextR][nextC].equals("X") && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        stack.add(new Site(nextR, nextC));
                        score += Integer.parseInt(m[nextR][nextC]);
                    }
                }
            }
            return score;
        }
    }

    class Site {
        int x;
        int y;

        Site(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
