import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, limit, emptyCount, result = Integer.MAX_VALUE;
    static int[][] originMap, map, virus;
    static boolean[] visit;
    static int[] activate;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] a) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        activate = new int[M];
        originMap = new int[N][N];
        map = new int[N][N];
        virus = new int[N * N][2];

        // Input
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                originMap[i][j] = input.charAt((j * 2)) - '0';
                if (originMap[i][j] == 2) {
                    virus[limit][0] = i;
                    virus[limit++][1] = j;
                } else if (originMap[i][j] == 0) {
                    emptyCount++;
                }
            }
        }// Input End

        if (emptyCount == 0) {
            System.out.println(0);
            return;
        }

        visit = new boolean[limit];
        solve(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void solve(int depth, int at) {
        if (depth == M) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = originMap[i][j];
                }
            }
            spreadVirus();
            return;
        }

        for (int i = at; i < limit; i++) {
            if (!visit[i]) {
                visit[i] = true;
                activate[depth] = i;
                solve(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }

    private static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            int[] v = virus[activate[i]];
            queue.add(v);
            map[v[0]][v[1]] = 1;
        }

        int time = 0, empty = 0;
        while (!queue.isEmpty()) {
            if(empty == emptyCount) break;
            if(time >= result) return;
            time++;

            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nX = cur[0] + dirX[i];
                    int nY = cur[1] + dirY[i];

                    if (!isIn(nX, nY) || map[nX][nY] == 1) {
                        continue;
                    }

                    // 빈칸이라면 empty 증가 후 벽으로 처리해서 못오게 함 큐에 바이러스를 넣어줌
                    if (map[nX][nY] == 0) {
                        empty++;
                    }
                    map[nX][nY] = 1;
                    queue.add(new int[]{nX,nY});
                }
            }
        }
        if (emptyCount == empty && result > time) {
            result = time;
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
