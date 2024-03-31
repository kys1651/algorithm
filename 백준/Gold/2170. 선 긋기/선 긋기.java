import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Input
        int[][] pos = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[i][0] = x;
            pos[i][1] = y;
        }// Input End

        Arrays.sort(pos, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int max = pos[0][1], min = pos[0][0];
        int result = max - min;
        for (int i = 1; i < N; i++) {
            // 이전 선에 포함되면 넘어간다.
            if (min <= pos[i][0] && pos[i][1] <= max)
                continue;

            if (pos[i][0] < max) {
                result += pos[i][1] - max;
            } else {
                result += pos[i][1] - pos[i][0];
            }
            max = pos[i][1];
            min = pos[i][0];
        }
        System.out.println(result);
    }
}
