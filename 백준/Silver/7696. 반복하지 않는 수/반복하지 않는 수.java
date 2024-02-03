import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    // N번째 수를 받는다.
    static int[] num = new int[10];
    static boolean[] visit = new boolean[10];
    static int N;
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while((N = Integer.parseInt(br.readLine())) != 0){
            sb.append(solution()).append('\n');
        }
        System.out.println(sb);
    }

    private static String solution() {
        result = "";
        int limit = 1;
        while (result.isEmpty()) {
            getNoRepeat(0,limit);
            limit++;
        }

        return result;
    }

    private static void getNoRepeat(int depth, int limit) {
        if(depth == limit){
            N--;
            if (N == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < limit; i++) {
                    sb.append("" + num[i]);
                }
                result = sb.toString();
            }
            return;
        }

        int start = depth == 0 ? 1 : 0;
        for (int i = start; i < 10; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            num[depth] = i;
            getNoRepeat(depth + 1, limit);
            visit[i] = false;
        }
    }
}
