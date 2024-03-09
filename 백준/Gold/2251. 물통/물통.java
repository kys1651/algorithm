import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int A, B, C;
    static boolean[][] visit = new boolean[201][201];
    static Set<Integer> answer = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dfs(0, 0, C);

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(' ');
        }
        System.out.println(sb);
    }

    private static void dfs(int a, int b, int c) {
        if (visit[a][b]) return;
        visit[a][b] = true;

        if (a == 0) {
            answer.add(c);
        }

        // a -> b
        if (a + b > B) {
            dfs((a + b) - B, B, c);
        } else {
            dfs(0, a + b, c);
        }

        // b -> a
        if (a + b > A) {
            dfs(A, a + b - A, c);
        } else {
            dfs(a + b, 0, c);
        }

        // c -> a
        if (c + a > A) {
            dfs(A, b, a + c - A);
        } else {
            dfs(c + a, b, 0);
        }

        // c -> b
        if (c + b > B) {
            dfs(a, B, c + b - B);
        } else {
            dfs(a, c + b, 0);
        }


        // a -> c
        dfs(0, b, a + c);
        // b -> c
        dfs(a, 0, b + c);

    }
}
