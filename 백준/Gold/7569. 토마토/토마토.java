import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;

class tomato{
    int x;
    int y;
    int h;

    public tomato(int h, int x, int y) {
        this.h= h;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][][] map;
    static int M,N,H;//가로 세로 높이
    static int[] dirx = {1,-1,0,0,0,0}; // 상,하
    static int[] diry = {0,0,-1,1,0,0}; // 좌,우
    static int[] dirh = {0,0,0,0,1,-1}; // 위,아래
    static Queue<tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for(int h = 0; h < H; h++){
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if(map[h][n][m] == 1) q.add(new tomato(h, n, m));
                }
            }
        }
        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {

        while (!q.isEmpty()) {
            tomato t = q.poll();

            int h = t.h;
            int y = t.y;
            int x = t.x;

            for (int i = 0; i < 6; i++) {
                int nx = x + dirx[i]; // 세로
                int ny = y + diry[i]; // 가로
                int nh = h + dirh[i]; // 높이

                // 유효한 범위 내
                if (nx >= 0 && ny >= 0 && nh >= 0 && nx < N && ny < M && nh < H) {
                    if(map[nh][nx][ny]==0){
                        q.offer(new tomato(nh, nx, ny));
                        map[nh][nx][ny] = map[h][x][y] + 1;
                    }
                }

            }
        }

        int result = -1;

        for (int h = 0; h < H; h++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if(map[h][x][y] == 0) {
                        return -1;
                    }

                    result = Math.max(result, map[h][x][y]);
                }
            }
        }
        if(result == 1) return 0;
        return result-1;
    }
}
