import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 200_001;
    static int N;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        init();
        // Input
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from][to] = cost;
        } // Input End

        floydWarshall();

        int K = Integer.parseInt(br.readLine());
        int[] friend = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            friend[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> answer = new ArrayList<>();
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 0; j < K; j++) {
                int idx = friend[j];
                if(tmp < graph[idx][i] + graph[i][idx]){
                    tmp = graph[idx][i] + graph[i][idx];
                }
            }

            if(minCount > tmp){
                answer.clear();
                answer.add(i);
                minCount = tmp;
            } else if (minCount == tmp) {
                answer.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(' ');
        }
        System.out.println(sb);
    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if(i == k || graph[i][k] == INF) continue;
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    private static void init() {
        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = INF;
            }
            graph[i][i] = 0;
        }
    }
}
