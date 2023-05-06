import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
        import java.util.ArrayDeque;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int n;
    static int m;
    static int[][] node;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        node = new int[n+1][n+1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            node[x][y] = node[y][x] = 1;
        }
        visited = new boolean[n + 1];
        dfs(1);

        System.out.println(result);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for(int i = 0 ; i <= n; i++){
            if(node[start][i] == 1 && !visited[i]){
                result++;
                dfs(i);
            }
        }
    }
}