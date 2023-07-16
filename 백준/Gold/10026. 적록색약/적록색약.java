import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char [][] cmap,map;
    static boolean[][] cv,v;

    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int ccount = 0;
        int count = 0;
        map = new char[N][N];
        cmap = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'G')
                    cmap[i][j] = 'R';
                else
                    cmap[i][j] = map[i][j];
            }
        }

        cv = new boolean[N][N];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!v[i][j]){
                    count++;
                    dfs(i, j, v, map, map[i][j]);
                }
                if (!cv[i][j]) {
                    ccount++;
                    dfs(i, j, cv, cmap, cmap[i][j]);
                }
            }
        }
        System.out.println(count + " " + ccount);
    }

    private static void dfs(int x, int y, boolean[][] bool, char[][] area, char color) {
        bool[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 > nx || nx >= N || 0 > ny || ny >= N){
                continue;
            }
            if (bool[nx][ny] || area[nx][ny] != color) {
                continue;
            }
            dfs(nx, ny, bool, area, color);
        }
    }

    private static boolean isCheck(int nx, int ny) {
        return 0 <= nx && nx < N && ny >= 0 && ny < N;
    }
}
