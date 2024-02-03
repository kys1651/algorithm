import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // N번째 수를 받는다.
    static int[] num;
    static boolean[] visit = new boolean[10];
    static int[] answer;
    static int N,count;
    static final int SIZE = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        answer = new int[SIZE];

        for (int limit = 1; limit <= 8; limit++) {
            num = new int[limit];
            for (int i = 1; i <= 9; i++) {
                if(count >= SIZE) break;

                visit[i] = true;
                num[0] = i;
                combination(1, limit);
                visit[i] = false;
            }
        }


        while((N = Integer.parseInt(br.readLine())) != 0){
            sb.append(answer[N - 1]).append('\n');
        }
        System.out.println(sb);
    }

    private static void combination(int depth, int limit){
        if(count >= SIZE) return;

        if (depth == limit) {
            int k = 0;
            for (int i = 0; i < limit; i++) {
                k *= 10;
                k += num[i];
            }
            answer[count++] = k;
            return;
        }


        for (int i = 0; i < 10; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            num[depth] = i;
            combination(depth + 1, limit);
            visit[i] = false;
        }
    }
}
