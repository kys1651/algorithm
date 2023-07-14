import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int num = 0, max = 0;
    static int [][] arr;
    static boolean [][] visited;
    static int N,M;
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 1 && visited[i][j] != true){
                    bfs(i, j);
                }
            }
        }

        System.out.println(num);
        System.out.println(max);
    }

    private static void bfs(int x, int y) {
        int count = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] n = queue.poll();
            int nx = n[0];
            int ny = n[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                // arr배열의 크기 밖이면 제외
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }
                // 이미 방문했거나 1이 아니라면 제외
                if (visited[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue;
                }

                // 범위안에 있고, 방문 안 한 상태, 배열의 값은 1일 때
                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                count++;
            }
        }

        num ++;
        max = Math.max(max, count);
    }
}
