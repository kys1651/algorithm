import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] input;
    static boolean[] visit;
    static int[] idx = new int[3];
    static int result, N , K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            result = 100;

            // Input
            input = new String[N];
            visit = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                input[i] = st.nextToken();
            }// Input End

            if(N > 32){
                sb.append(0).append('\n');
                continue;
            }
            K = 3;
            // N개중 3개를 뽑아냄
            combination(0, 0);

            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    private static void combination(int depth, int at) {
        if(result == 0){
            return;
        }
        
        if (depth == K) {
            String a = input[idx[0]];
            String b = input[idx[1]];
            String c = input[idx[2]];
            int tmp = getDistance(a, b);
            tmp += getDistance(a, c);
            tmp += getDistance(b, c);
            if (tmp < result) {
                result = tmp;
            }

            return;
        }

        for (int i = at; i < N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            idx[depth] = i;
            combination(depth + 1, i + 1);
            visit[i] = false;
        }
    }

    private static int getDistance(String a, String b) {
        int count = 4;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count--;
            }
        }
        return count;
    }
}