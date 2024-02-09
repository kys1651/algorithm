import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 배열의 길이
    static int N;
    // 적록색약 아닌 배열, 적록색약 배열
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int no = 0, yes = 0;
        char[][] noMap = new char[N][N];
        char[][] yesMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                noMap[i][j] = input.charAt(j);
                if (noMap[i][j] == 'G') {
                    yesMap[i][j] = 'R';
                } else {
                    yesMap[i][j] = noMap[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (noMap[i][j] != ' ') {
                    no++;
                    dfs(i, j, noMap);
                }
                if (yesMap[i][j] != ' ') {
                    yes++;
                    dfs(i, j, yesMap);
                }
            }
        }
        System.out.println(no + " " + yes);
    }

    private static void dfs(int x, int y, char[][] map) {
        char color = map[x][y];
        map[x][y] = ' ';


        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if (nX < 0 || nX >= N || nY < 0 || nY >= N || map[nX][nY] != color) {
                continue;
            }
            dfs(nX, nY, map);
        }
    }
}