package search;

import java.util.LinkedList;
import java.util.Queue;

public class PROG_LEVEL2_게임맵최단거리 {

    public int solution(int[][] maps) {
        int answer = 0;
        Queue<Site> que = new LinkedList<>();
        que.add(new Site(0, 0));
        int[][] sites = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        while (!que.isEmpty()) {
            Site site = que.poll();
            for (int[] s : sites) {
                int x = site.x + s[0];
                int y = site.y + s[1];

                if (x > -1 && x < n && y > -1 && y < m && maps[x][y] != 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    maps[x][y] += maps[site.x][site.y];
                    que.add(new Site(x, y));
                }
            }
        }

        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
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
