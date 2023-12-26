import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static int n,m,time,cheeseCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while (cheesesCheck()){
            time++;
            visit = new boolean[n][m];
            dfs(0, 0);
            cheeseCount = 0;
        }

        System.out.println(time);
        System.out.println(cheeseCount);
    }

    private static boolean cheesesCheck() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 2){
                    map[i][j] = 0;
                    cheeseCount++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void dfs(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nX = x + dirX[d];
            int nY = y + dirY[d];

            if (check(nX, nY) || visit[nX][nY]) {
                continue;
            }

            visit[nX][nY] = true;
            if (map[nX][nY] == 1) {
                map[nX][nY] = 2;
            }else{
                dfs(nX, nY);
            }
        }
    }

    private static boolean check(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }


}