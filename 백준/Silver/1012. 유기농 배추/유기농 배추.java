import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dirx = {0, 0, -1, 1};
    static int[] diry = {-1, 1, 0, 0};
    static int N,M,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0 ; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for(int i = 0 ; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] != 0 && !visited[i][j]) {
                        count++;
                        bfs(i,j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int n[] = q.poll();
            int nx = n[0];
            int ny = n[1];

            for(int pos = 0; pos < 4; pos++){
                int posx = nx + dirx[pos];
                int posy = ny + diry[pos];

                if(posx < 0 || posy < 0 || posx >= N || posy >= M)
                    continue;
                if(map[posx][posy]==0||visited[posx][posy])
                    continue;

                visited[posx][posy] = true;
                q.offer(new int[]{posx, posy});
            }
        }

    }

}
