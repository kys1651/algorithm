import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Init
        ArrayList<int[]> meteorList = new ArrayList<>();
        int[] wallHeight = new int[M];
        int[] meteorHeight = new int[M];
        for (int i = 0; i < M; i++) {
            wallHeight[i] = 3001;
            meteorHeight[i] = -1;
        }// Init End

        // Input
        String input;
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = input.charAt(j);
                if (ch == '#') {
                    map[i][j] = 1;
                    wallHeight[j] = Math.min(wallHeight[j], i);
                } else if (ch == 'X') {
                    map[i][j] = 0;
                    meteorHeight[j] = Math.max(meteorHeight[j], i);
                    meteorList.add(new int[]{i, j});
                }
            }
        }// Input End

        int minDist = 3001;
        for (int i = 0; i < M; i++) if (meteorHeight[i] != -1) minDist = Math.min(minDist, wallHeight[i] - meteorHeight[i] - 1);
        for (int[] m : meteorList) map[m[0] + minDist][m[1]] = 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) sb.append('#');
                else if (map[i][j] == 2) sb.append('X');
                else sb.append('.');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}