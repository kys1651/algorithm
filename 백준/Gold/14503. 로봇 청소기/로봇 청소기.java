import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int [][] map;
    static int N, M;
    static int count = 0 ;
    // 동서남북이 아닌 북동남서로 저장
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r, c, dir);

        System.out.println(count);
    }

    private static void dfs(int row, int col, int dir) {
        // -1: 청소 0: 청소 X 1: 벽
        if(map[row][col] == 0){ //청소 안됐으면 청소하기
            map[row][col] = 2;
            count++;
        }

        int origin = dir;
        for (int i = 0; i < 4; i++) {
            int nextD = dir = (dir + 3) % 4; // 방향을 바꿈 북 -> 서 -> 남 -> 동
            int nextR = row + dr[nextD];
            int nextC = col + dc[nextD];


            // 허용되는 범위 내에서 청소 안한 곳이 있을 시
            if (nextR > 0 && nextC > 0 && nextR < N && nextC < M) {
                if (map[nextR][nextC] == 0) {
                    dfs(nextR, nextC, nextD);

                    return;
                }
            }
        }

        int backD = (origin + 2) % 4;
        int backR = row + dr[backD];
        int backC = col + dc[backD];

        if (backR > 0 && backC > 0 && backR < N && backC < M) {
            if (map[backR][backC] != 1) {
                dfs(backR, backC, origin);
            }
        }

    }

}
