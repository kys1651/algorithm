import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] visit;
    static int n;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new int[n];
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            result++;
            return;
        }
        for(int i = 0; i < n; i++){
            visit[depth] = i;
            if (check(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            // 같은 행에 존재 
            if (visit[i] == visit[depth]) {
                return false;
            }
            // 대각선 존재
            else if (Math.abs(i - depth) == Math.abs(visit[i] - visit[depth])) {
                return false;
            }
        }
        
        // 유효한 위치
        return true;
    }
}
