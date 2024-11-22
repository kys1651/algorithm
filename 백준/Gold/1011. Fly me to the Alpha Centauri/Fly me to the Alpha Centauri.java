import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int T = 1; T <= TC; T++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            answer.append(solve(start, end)).append('\n');
        }
        System.out.println(answer);
    }

    private static int solve(int from, int to) {
        int distance = to - from;
        int max = (int) Math.sqrt(distance);
        int moveCount = 2 * max;

        if (max == Math.sqrt(distance)) {
            return moveCount - 1;
        }
        if (distance <= max * max + max) {
            return moveCount;
        }
        return moveCount + 1;
    }
}