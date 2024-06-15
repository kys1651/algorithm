import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]> milk = new ArrayList<>();
    static boolean[] eat;
    static int[][] dist;
    static boolean[][][] visit;
    static int N, H, result;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int sX = 0, sY = 0;

        // Input
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    sX = i;
                    sY = j;
                } else if (val == 2) {
                    milk.add(new int[]{i, j});
                }
            }
        } // Input End

        visit = new boolean[milk.size() + 1][N][N];
        eat = new boolean[milk.size()];
        // 다른 위치 -> 진우 집 갈 수 있는 거리를 구해준다.
        getHomeDist(sX, sY);
        solve(sX, sY, M, 0);
        System.out.println(result);
    }

    private static void solve(int x, int y, int move, int eatCount) {
        if (dist[x][y] <= move && result < eatCount) {
            result = eatCount;
        }

        // 이미 최대값만큼 먹었거나 움직일 수 없다면 멈춤
        if (result == milk.size() || move == 0) {
            return;
        }

        for (int i = 0; i < milk.size(); i++) {
            int[] m = milk.get(i);
            int d = getDist(x, y, m[0], m[1]);
            // 갈 수 없거나 먹은 적 있다면 넘어간다.
            if (d > move || eat[i]) {
                continue;
            }
            eat[i] = true;
            solve(m[0], m[1], move - d + H, eatCount + 1);
            eat[i] = false;
        }
    }

    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static void getHomeDist(int sX, int sY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sX, sY});
        boolean[][] visit = new boolean[N][N];
        visit[sX][sY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];
                if (isIn(nX, nY) && !visit[nX][nY]) {
                    dist[nX][nY] = dist[cur[0]][cur[1]] + 1;
                    visit[nX][nY] = true;
                    q.offer(new int[]{nX, nY});
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}