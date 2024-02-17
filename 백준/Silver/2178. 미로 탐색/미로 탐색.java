import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Input
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0,1});
        map[0][0] = '0';

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                System.out.println(cur[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M || map[nX][nY] == '0') {
                    continue;
                }

                map[nX][nY] = '0';
                queue.offer(new int[]{nX, nY, cur[2] + 1});
            }
        }
    }
}

