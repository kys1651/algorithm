import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 배열의 크기 N, 뽑아야 할 바이러스 M, 바이러스의 총개수 limit, 빈공간의 개수 emptyCount
    static int N, M, limit, emptyCount, result = Integer.MAX_VALUE;
    // 원본 배열 맵, 값을 처리하기 위한 map, 바이러스의 위치virus
    static int[][] originMap, virus;
    static boolean[][] map;
    // 방문처리 visit;
    static boolean[] visit;
    // 뽑아낸 바이러스의 수
    static int[] activate;
    // 상,하,좌우
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] a) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        activate = new int[M];
        originMap = new int[N][N];
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

        // 빈 공간이 없으면 바로 종료
        if (emptyCount == 0) {
            System.out.println(0);
            return;
        }

        visit = new boolean[limit];
        solve(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void solve(int depth, int at) {
        // M개 뽑으면 배열을 복사해준다.
        if (depth == M) {
            // 바이러스를 퍼뜨림
            spreadVirus();
            return;
        }

        // 바이러스를 뽑아낸다.
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
        map = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        // 바이러스를 넣어주면서 바로 벽으로 처리해준다.(더 이상 갈 수 없도록)
        for (int i = 0; i < M; i++) {
            int[] v = virus[activate[i]];
            queue.add(v);
            map[v[0]][v[1]] = true;
        }

        int time = 0, empty = 0;
        while (!queue.isEmpty()) {
            // 빈공간이 없다면 종료
            if (empty == emptyCount) break;
            // result보다 크거나 같다면 유효하지 않음
            if (time >= result) return;
            time++;

            int size = queue.size();
            // 현재 있는 바이러스 개수만큼만 진행
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();

                // 상,하,좌,우 확인
                for (int i = 0; i < 4; i++) {
                    int nX = cur[0] + dirX[i];
                    int nY = cur[1] + dirY[i];

                    // 배열 범위내이고 벽이 아니여야한다.
                    if (!isIn(nX, nY) || originMap[nX][nY] == 1 || map[nX][nY]) {
                        continue;
                    }

                    // 빈칸이라면 empty 증가
                    if (originMap[nX][nY] == 0) {
                        empty++;
                    }
                    map[nX][nY] = true;
                    queue.add(new int[]{nX, nY});
                }
            }
        }
        // 빈공간이 없고 result보다 작다면 갱신
        if (emptyCount == empty && result > time) {
            result = time;
        }
    }
    
    // 범위내인지 확인
    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
