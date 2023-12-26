import java.util.Scanner;
class Solution {
    static int n,m;
    static int[][] map;
    public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 상하좌우
        int[] cX = {-1,1,0,0};
        int[] cY = {0,0,-1,1};

        // 대각선
        int[] xX = {-1,-1,1,1};
        int[] xY ={1,-1,1,-1};
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            n = sc.nextInt();
            m = sc.nextInt();
            map = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            int result = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int c = spray(i,j,cX,cY);
                    int x = spray(i,j,xX,xY);
                    if(c > result) result = c;
                    if(x > result) result = x;
                }
            }
            sb.append("#" + tc + " "+ result).append("\n");
        }
        System.out.println(sb);
    }

    private static int spray(int x,int y,int[] dirX, int[] dirY){
        int result = map[x][y];
        for(int i = 0; i < 4; i++){
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            int count = 1;
            while(check(nX,nY) && count < m){
                result += map[nX][nY];
                nX += dirX[i];
                nY += dirY[i];
                count++;
            }
        }
        return result;
    }

    private static boolean check(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}