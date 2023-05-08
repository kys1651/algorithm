import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dirx = {0, 0, -1, 1};
    static int[] diry = {-1, 1, 0, 0};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int part = countpart();

            if (part >= 2)
                break;
            if (part == 0) {
                year = 0;
                break;
            }

            year++;
            bfs();
        }

        System.out.println(year);
    }

    private static int countpart () {
        visited = new boolean[N][M];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        for(int n = 0 ; n < 4; n++){
            int posx = i + dirx[n];
            int posy = j + diry[n];

            if(posx < 0 || posy < 0 || posx >= N || posy >= M)
                continue;
            if (map[posx][posy] == 0 || visited[posx][posy])
                continue;

            dfs(posx, posy);
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                if(map[i][j] > 0){
                    q.offer(new int[] {i,j});
                    check[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int n[] = q.poll();
            int nx = n[0];
            int ny = n[1];

            int minus = 0;
            for(int i = 0 ; i < 4; i++){
                int posx = nx + dirx[i];
                int posy = ny + diry[i];

                if (posx < 0 || posy < 0 || posx >= N  || posy >= M)
                    continue;
                if(visited[posx][posy] || map[posx][posy]!=0)
                    continue;
                minus++;
            }
            map[nx][ny] -= minus;
            map[nx][ny] = Math.max(map[nx][ny],0);
        }
    }



}
