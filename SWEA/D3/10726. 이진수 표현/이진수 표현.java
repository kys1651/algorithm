import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int check = (1 << N) - 1;

            sb.append('#').append(tc).append(' ');
            if ((M & check) == check) {
                sb.append("ON");
            } else {
                sb.append("OFF");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
