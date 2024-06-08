import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][][] map = new int[3][N + 1][M + 1];

        int K = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> getIdx = new HashMap<>();
        getIdx.put('J', 0);
        getIdx.put('O', 1);
        getIdx.put('I', 2);

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                char ch = input.charAt(j - 1);
                for (int k = 0; k < 3; k++) {
                    map[k][i][j] = map[k][i - 1][j] + map[k][i][j - 1] - map[k][i - 1][j - 1];
                }
                map[getIdx.get(ch)][i][j]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) {
                int result = map[j][eX][eY] - map[j][sX - 1][eY] - map[j][eX][sY - 1] + map[j][sX - 1][sY - 1];
                sb.append(result).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}