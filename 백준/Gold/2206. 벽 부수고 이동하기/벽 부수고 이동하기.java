import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    // 상, 하, 좌, 우
    static int[] posx = {0, 0, -1, 1};
    static int[] posy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력받음
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 시작 위치와 종료 위치가 같은 경우
        if (N - 1 == 0 && M - 1 == 0) {
            System.out.println(1);
            System.exit(0);
        }

        int[][] miro = new int[N][M];
        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[2][N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = tmp.charAt(j) - '0';
            }
        }

        // 시작 점 좌표(0,0) 부신 적 x
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + posx[i];
                int nY = cur[1] + posy[i];

                // 미로 밖으로 나간 범위 일 때 넘겨줌
                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                // 다음 칸에 벽이 있을 때
                // 1. 벽을 부순 적 있는가?
                // 2. 벽을 방문한 적 있는가?
                if (miro[nX][nY] == 1) {
                    // cur[2]가 0이면 부순 적 없음  visited[1][nX][nY]가 false면 방문한 적 없음
                    if (cur[2] == 0 && !visited[1][nX][nY]) {
                        visited[cur[2]][nX][nY] = true; // 방문 표시
                        map[nX][nY] = map[cur[0]][cur[1]] + 1; // 다음 거리에 현재 거리에서 1 더해줌
                        // 다음 위치를 넣어주고 벽 부순적 있다고 넣어줌
                        q.offer(new int[]{nX, nY, 1});
                    }
                }
                else{ // 벽이 아닐 경우
                    // 내가 부수고 왔는지 아닌지 메모 해야함
                    if (!visited[cur[2]][nX][nY]) {// 방문 안 했을 때
                        visited[cur[2]][nX][nY] = true;
                        map[nX][nY] = map[cur[0]][cur[1]] + 1;
                        q.offer(new int[]{nX, nY, cur[2]});
                    }
                }

                // 도착 지점에 방문 했을 때 확인
                if (nX == N - 1 && nY == M - 1) {
                    System.out.println(map[N - 1][M - 1] + 1);
                    System.exit(0);
                }
            }
        }

        System.out.println(-1);
    }
}
