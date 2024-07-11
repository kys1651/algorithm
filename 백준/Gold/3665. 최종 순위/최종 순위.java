import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final String FAIL = "IMPOSSIBLE";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            boolean[][] graph = new boolean[N + 1][N + 1];
            int[] inDegree = new int[N + 1];

            // Input
            int[] rank = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int v = Integer.parseInt(st.nextToken());
                for (int j = 1; j <= N; j++) {
                    if (rank[j] != 0 || j == v) continue;
                    inDegree[v]++;
                    graph[j][v] = true;
                }
                rank[v] = i;
            }// Input End

            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (!graph[a][b]) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                graph[a][b] = false;
                graph[b][a] = true;
                inDegree[a]++;
                inDegree[b]--;
            }

            sb.append(topologySort(N, rank, graph, inDegree)).append('\n');
        }
        System.out.println(sb);

    }

    private static String topologySort(int N, int[] rank, boolean[][] graph, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int count = N;
        while (count != 0) {
            if (queue.isEmpty()) {
                return FAIL;
            }

            int cur = queue.poll();
            rank[count--] = cur;
            for (int i = 1; i <= N; i++) {
                if (i == cur || !graph[cur][i]) continue;
                if (--inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(rank[i]).append(' ');
        }
        return sb.toString();
    }
}