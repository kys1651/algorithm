import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]> list = new ArrayList<>();
    static int[] maxStart, maxEnd;
    static int max, N, M;
    static int[][] map;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // Input
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) == 'W' ? -1 : 0;
                if (map[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }// Input End

        for (int[] start : list) {
            bfs(start);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(maxStart);
        map[maxStart[0]][maxStart[1]] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (!isIn(nX, nY) || map[nX][nY] != 0) {
                    continue;
                }
                map[nX][nY] = map[cur[0]][cur[1]] + 1;
                queue.add(new int[]{nX, nY});

                if (nX == maxEnd[0] && nY == maxEnd[1]) {
                    System.out.println(map[nX][nY] - 1);
                    return;
                }
            }
        }
    }

    private static void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});

        boolean[][] visit = new boolean[N][M];
        visit[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[2] > max) {
                max = cur[2];
                maxStart = start;
                maxEnd = cur;
            }
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (!isIn(nX, nY) || map[nX][nY] == -1 || visit[nX][nY]) {
                    continue;
                }
                visit[nX][nY] = true;
                queue.add(new int[]{nX, nY, cur[2] + 1});
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}