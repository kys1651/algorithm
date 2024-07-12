import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int WALL = 1, METEOR = 2;

    static int N, M;
    static int[][] map;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Input
        map = new int[N][M];
        ArrayList<int[]> meteorList = new ArrayList<>();
        String input;
        int[] wallHeight = new int[M];
        Arrays.fill(wallHeight, 3001);
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = input.charAt(j);
                if (ch == '#') {
                    map[i][j] = WALL;
                    wallHeight[j] = Math.min(wallHeight[j], i);
                } else if (ch == 'X') {
                    map[i][j] = 0;
                    meteorList.add(new int[]{i, j});
                }
            }
        }// Input End

        int minDist = 3001;
        for (int[] m : meteorList) {
            int b = wallHeight[m[1]] - m[0] - 1;
            minDist = Math.min(minDist, b);
        }

        for(int[] m : meteorList) {
            map[m[0] + minDist][m[1]] = METEOR;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == WALL) {
                    sb.append("#");
                } else if (map[i][j] == METEOR) {
                    sb.append("X");
                } else {
                    sb.append(".");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}