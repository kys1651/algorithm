import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M, K;
    static int[][] map;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, 0, 0);

        System.out.println(answer);
    }

    private static void solution(int r, int c, int depth, int sum) {
        if (depth == K) {
            answer = Math.max(answer, sum);
            return;
        }

        boolean flag;
        for (int i = r; i < N; i++) {
            for (int j = (i == r) ? c : 0; j < M; j++) {
                if(visited[i][j]) continue;

                flag = true;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc]) {
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    visited[i][j] = true;
                    solution(i, j, depth + 1, sum + map[i][j]);
                    visited[i][j] = false;
                }
            }
        }
    }
}


