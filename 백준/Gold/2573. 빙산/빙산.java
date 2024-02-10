import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M; // 배열 크기 N,M
    static int[][] map; // 원본 맵
    static boolean[][] visit; // 방문 처리를 위한 visit 배열
    static ArrayList<Pos> ice = new ArrayList<>(); // 빙산들의 위치를 담는 ArrayList
    // 방향 -> 상,하,좌,우
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];
        map = new int[N][M];

        // Input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 빙산의 위치 저장
                if (map[i][j] != 0) {
                    ice.add(new Pos(i, j));
                }
            }
        }

        int answer = 0;
        while (!ice.isEmpty()) {
            answer++;
            visit = new boolean[N][M];


            // 녹이기
            for (int i = 0; i < ice.size(); i++) {
                Pos p = ice.get(i);
                removeIce(p);

                // 녹았다면 -1로 갱신(방금 지워졌다고 표시
                if (map[p.x][p.y] <= 0) {
                    map[p.x][p.y] = 0;
                    visit[p.x][p.y] = true;
                    ice.remove(p);
                    i--;
                }
            }

            // 구역 확인
            int section = 0;

            for (int i = 0; i < ice.size(); i++) {
                Pos p = ice.get(i);

                // 녹지 않은 빙산 중 방문하지 않았다면 dfs로 연결된 부분을 방문 처리
                if (!visit[p.x][p.y]) {
                    section++;
                    dfs(p.x, p.y);
                }
            }


            if (section >= 2) {
                System.out.println(answer);
                System.exit(0);
            }
        }

        System.out.println(0);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            if (map[nX][nY] <= 0 || visit[nX][nY]) continue;
            // 방문 처리
            dfs(nX, nY);
        }
    }

    // 상,하,좌,우에 바닷물이 접한지 확인
    private static int removeIce(Pos p) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nX = p.x + dirX[i];
            int nY = p.y + dirY[i];

            if (!visit[nX][nY] && map[nX][nY] == 0) {
                map[p.x][p.y]--;
            }
        }

        return count;
    }
}