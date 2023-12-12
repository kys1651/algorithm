import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        answer = new int[a][b];

        int[] start = new int[2];
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < b; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    answer[i][j] = -1;
                }
                else if (tmp == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        bfs(start);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        answer[start[0]][start[1]] = 0;
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (nX < 0 || nX >= answer.length || nY < 0 || nY >= answer[nX].length) {
                    continue;
                }
                if (answer[nX][nY] != -1) {
                    continue;
                }
                answer[nX][nY] = answer[cur[0]][cur[1]] + 1;
                queue.offer(new int[] {nX, nY});
            }
        }
    }
}