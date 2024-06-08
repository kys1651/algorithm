import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        // Input
        int[][][] map = new int[3][N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k < 3; k++) {
                    map[k][i][j] = map[k][i - 1][j] + map[k][i][j - 1] - map[k][i - 1][j - 1];
                }

                char ch = input.charAt(j - 1);
                if (ch == 'J') {
                    map[0][i][j]++;
                } else if (ch == 'O') {
                    map[1][i][j]++;
                } else {
                    map[2][i][j]++;
                }
            }
        }// Input End

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());

            int jungle = map[0][eX][eY] - map[0][sX - 1][eY] - map[0][eX][sY - 1] + map[0][sX - 1][sY - 1];
            int ocean = map[1][eX][eY] - map[1][sX - 1][eY] - map[1][eX][sY - 1] + map[1][sX - 1][sY - 1];
            int ice = map[2][eX][eY] - map[2][sX - 1][eY] - map[2][eX][sY - 1] + map[2][sX - 1][sY - 1];
            sb.append(jungle).append(' ').append(ocean).append(' ').append(ice).append('\n');
        }

        System.out.println(sb);
    }
}