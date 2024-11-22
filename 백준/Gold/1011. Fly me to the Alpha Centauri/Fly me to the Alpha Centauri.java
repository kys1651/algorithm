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
            int distance = end - start;
            int max = (int) Math.sqrt(distance);
            if (max == Math.sqrt(distance)) {
                answer.append(2 * max - 1);
            } else if (distance <= max * max + max) {
                answer.append(2 * max);
            } else {
                answer.append(2 * max + 1);
            }
            answer.append('\n');
        }
        System.out.println(answer);
    }
}