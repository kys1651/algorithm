import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    // 토마토의 위치 저장
    static class tomato {
        int x;
        int y;

        public tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // 상, 하, 좌, 우
    static int[] posx = {0, 0, -1, 1};
    static int[] posy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력받음
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        Queue<tomato> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;

                if (n == 1) {
                    // 토마토의 위치를 저장해줌
                    q.offer(new tomato(i, j));
                }
            }

        }


        while (!q.isEmpty()) {
            // 현재 위치
            tomato cur = q.poll();

            // 상,하,좌,우 확인
            for (int i = 0; i < 4; i++) {
                int nX = cur.x + posx[i];
                int nY = cur.y + posy[i];

                // 범위 밖이면 넘겨준다.
                if (nX < 0 || nX >= M || nY < 0 || nY >= N) {
                    continue;
                }

                // 토마토가 안 익었을 때만 처리한다.
                if (map[nX][nY] == 0) {
                    map[nX][nY] = map[cur.x][cur.y] + 1;
                    q.offer(new tomato(nX, nY));
                }
            }
        }

        // 최대값을 찾아준다.
        int answer = Integer.MIN_VALUE;
        boolean flag = false;
        for (int[] checks : map) {
            for (int check : checks) {
                answer = Math.max(answer, check);
                if (check == 0) {
                    flag = true;
                }
            }
        }

        if(flag){
            System.out.println(-1);
        }else{
            System.out.println(answer - 1);
        }

    }
}
