import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D, result;
    static int[][] map;
    static int[][] copyMap;
    static int[] archer = new int[3];

    // 상,좌,우
    static int[] dirX = {-1, 0, 0};
    static int[] dirY = {0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        copyMap = new int[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);

        System.out.println(result);
    }

    private static void combination(int depth, int at) {
        if (depth == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }
            removeEnemy();

            if(result == N * 3){
                System.out.println(result);
                System.exit(0);
            }
            return;
        }

        for (int i = at; i < M; i++) {
            archer[depth] = i;
            combination(depth + 1, i + 1);
        }
    }

    private static void removeEnemy() {
        int turn = 0;
        int count = 0;
        while (turn != N) {
            // 아처가 N - turn을 통해서 한칸씩 올라감 -> 적이 한칸씩 내려오는 것과 같음
            for (int i = 0; i < 3; i++) {
                bfs(N - turn, archer[i]);
            }

            // 맵에 적이 존재하지 않는다면 종료
            boolean exit = true;
            for (int i = N - turn - 1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    // 사라진 적을 제거 해줌
                    if (copyMap[i][j] == -1) {
                        copyMap[i][j] = 0;
                        count++;
                    } else if (copyMap[i][j] != 0) {
                        exit = false;
                    }
                }
            }

            // 적이 존재하지 않는다면 종료
            if (exit) {
                break;
            }

            // 방금 적들은 모두 제거 해줌(성으로 간 적들)
//            for (int i = 0; i < M; i++) {
//                copyMap[N - turn - 1][i] = 0;
//            }

            turn++;
        }

        if (result < count) result = count;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        // 아처의 시작점,거리 삽입
        queue.add(new int[]{x, y, 0});

        // 방문 배열
        boolean[][] visit = new boolean[N][M];
        int minDist = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();

            // 상,좌,우만 확인하면 된다.
            for (int i = 0; i < 3; i++) {
                int nX = cur[0] + dirX[i]; // 다음 X
                int nY = cur[1] + dirY[i]; // 다음 Y
                int nextDist = cur[2] + 1; // 아처와의 거리

                // 배열 범위 밖이거나 || 제한 밖이라면 out
                if (nX < 0 || nX >= x || nY < 0 || nY >= M || nextDist > D || visit[nX][nY]) {
                    continue;
                }

                visit[nX][nY] = true;
                queue.add(new int[]{nX, nY, nextDist});
                // 적이 있다면
                if (copyMap[nX][nY] != 0) {
                    // 최소거리라면 갱신
                    if (nextDist < minDist) {
                        minX = nX;
                        minY = nY;
                        minDist = nextDist;
                    }
                    // 만약 거리가 같다면 왼쪽(Y가 짧음) 값
                    else if (nextDist == minDist) {
                        if (nY < minY) {
                            minX = nX;
                            minY = nY;
                        }
                    }
                }
            }
        }

        // minX 혹은 minY가 최대값이라면 제거 할 적이 없는 것임
        if (minX == Integer.MAX_VALUE || minY == Integer.MAX_VALUE) {
            return;
        }

        copyMap[minX][minY] = -1;
    }
}