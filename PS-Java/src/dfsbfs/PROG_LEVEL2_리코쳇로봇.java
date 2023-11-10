package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PROG_LEVEL2_리코쳇로봇 {

    int rowSize;
    int colSize;
    String[][] maps;
    boolean[][] visited;

    public int solution(String[] board) {
        rowSize = board.length;
        colSize = board[0].length();

        maps = new String[rowSize][];
        for (int i = 0; i < rowSize; i++) {
            maps[i] = board[i].split("");
        }

        visited = new boolean[rowSize][colSize];
        Site endSite = null;
        Queue<Site> que = new LinkedList<>();
        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (maps[r][c].equals("R")) {
                    que.add(new Site(r, c, 1));
                    visited[r][c] = true;
                }
                if (maps[r][c].equals("G")) {
                    endSite = new Site(r, c, 0);
                }
            }
        }

        while (!que.isEmpty()) {
            Site site = que.poll();
            if (site.c == endSite.c && site.r == endSite.r) return site.count - 1;
            List<Site> next = getNextSites(site);

            que.addAll(next);
        }

        return -1;
    }

    private List<Site> getNextSites(Site site) {
        List<Site> sites = new ArrayList<>();
        leftSite(sites, site);
        rightSite(sites, site);
        upSite(sites, site);
        downSite(sites, site);

        return sites;
    }

    private void leftSite(List<Site> sites, Site site) {
        int c = site.c;
        while (c > -1) {
            if (maps[site.r][c].equals("D")) {
                if (visited[site.r][c + 1]) break;
                visited[site.r][c + 1] = true;
                sites.add(new Site(site.r, c + 1, site.count + 1));
                break;
            } else if (c == 0 && !visited[site.r][c]) {
                sites.add(new Site(site.r, c, site.count + 1));
                visited[site.r][c] = true;
            }
            c--;
        }
    }

    private void rightSite(List<Site> sites, Site site) {
        int c = site.c;
        while (c < colSize) {
            if (maps[site.r][c].equals("D")) {
                if (visited[site.r][c - 1]) break;
                visited[site.r][c - 1] = true;
                sites.add(new Site(site.r, c - 1, site.count + 1));
                break;
            } else if (c == colSize - 1 && !visited[site.r][c]) {
                sites.add(new Site(site.r, c, site.count + 1));
                visited[site.r][c] = true;
            }
            c++;
        }
    }

    private void downSite(List<Site> sites, Site site) {
        int r = site.r;
        while (r < rowSize) {
            if (maps[r][site.c].equals("D")) {
                if (visited[r - 1][site.c]) break;
                visited[r - 1][site.c] = true;
                sites.add(new Site(r - 1, site.c, site.count + 1));
                break;
            } else if (r == rowSize - 1 && !visited[r][site.c]) {
                sites.add(new Site(r, site.c, site.count + 1));
                visited[r][site.c] = true;
            }
            r++;
        }
    }

    private void upSite(List<Site> sites, Site site) {
        int r = site.r;
        while (r > -1) {
            if (maps[r][site.c].equals("D")) {
                if (visited[r + 1][site.c]) break;
                visited[r + 1][site.c] = true;
                sites.add(new Site(r + 1, site.c, site.count + 1));
                break;
            } else if (r == 0 && !visited[r][site.c]) {
                sites.add(new Site(r, site.c, site.count + 1));
                visited[r][site.c] = true;
            }
            r--;
        }
    }

    class Site {
        int r;
        int c;
        int count;

        Site(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}
