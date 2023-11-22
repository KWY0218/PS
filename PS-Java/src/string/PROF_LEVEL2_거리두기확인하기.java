package string;

public class PROF_LEVEL2_거리두기확인하기 {
    class Solution {
        public int[] solution(String[][] places) {
            int[] answer = new int[5];
            for(int i = 0 ; i<5 ; i++) {
                String[][] p = new String[5][];
                boolean b = true;
                for(int j = 0 ; j<5 ; j++) {
                    p[j] = places[i][j].split("");
                }
                for(int row = 0 ; row<5 ; row++) {
                    for(int col = 0 ; col<5; col++) {
                        if(p[row][col].equals("P") && !(case1(p,row,col)&&case2(p,row,col)&&case3(p,row,col))) {
                            b = false;
                            break;
                        }
                    }
                    if(!b) break;
                }
                if(b) answer[i] = 1;
                else answer[i] = 0;
            }
            return answer;
        }

        boolean case1(String[][] places, int row, int col) {
            int[][] pSites = {{0,2},{0,-2},{2,0},{-2,0}};
            int[][] xSites = {{0,1},{0,-1},{1,0},{-1,0}};

            for(int i = 0; i<4 ; i++) {
                int r = row + pSites[i][0];
                int c = col + pSites[i][1];
                if(r>=0 && r<5 && c>=0 && c<5 && places[r][c].equals("P")) {
                    int r2 = row + xSites[i][0];
                    int c2 = col + xSites[i][1];
                    if(!places[r2][c2].equals("X")) return false;
                }
            }
            return true;
        }

        boolean case2(String[][] places, int row, int col) {
            int[][] pSites = {{0,1},{0,-1},{1,0},{-1,0}};

            for(int i = 0; i<4 ; i++) {
                int r = row + pSites[i][0];
                int c = col + pSites[i][1];
                if(r>=0 && r<5 && c>=0 && c<5 && places[r][c].equals("P")) return false;
            }
            return true;
        }

        boolean case3(String[][] places, int row, int col) {
            int[][] pSites = {{-1,1},{1,1},{1,-1},{-1,-1}};

            for(int i = 0; i<4 ; i++) {
                int r = row + pSites[i][0];
                int c = col + pSites[i][1];
                if(r>=0 && r<5 && c>=0 && c<5 && places[r][c].equals("P")) {
                    int r2 = row + pSites[i][0];
                    int c2 = col;
                    int r3 = row;
                    int c3 = col + pSites[i][1];
                    if(!(places[r2][c2].equals("X")&&places[r3][c3].equals("X"))) return false;
                }
            }
            return true;
        }
    }
}
