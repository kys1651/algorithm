import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 도시 개수 입력 받기
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            if (graph[from][to] != 0) {
                graph[from][to] = Math.min(graph[from][to], value);
            }else{
                graph[from][to] = value;
            }

        }

        floydWarshall();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 각 최소비용을 갱신해준다.
    private static void floydWarshall() {
        // 거쳐가는 도시
        for (int k = 0; k < n; k++) {
            // 출발 도시
            for (int i = 0; i < n; i++) {
                // 본인을 거쳐야하거나 거쳐야하는 도시를 갈 수 없다면 continue;
                if(k == i || graph[i][k]  == 0){
                    continue;
                }

                // 도착 도시
                for (int j = 0; j < n; j++) {
                    // 출발 도시와 도착 도시가 같다면 확인 할 필요 없다.
                    if(i == j){
                        continue;
                    }
                    // i도시에서 k도시로 갈 수 있는 노선이 연결 && k도시에서 j도시로 갈 수 있는 노선이 연결된 경우
                    if (graph[i][k] != 0 && graph[k][j] != 0) {
                        // 기존 노선이 연결되지 않은 경우
                        if(graph[i][j] == 0){
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }
                        // 기존에 이미 노선이 있는 경우는 최소값으로 연결한다.
                        else if(graph[i][j] > graph[i][k] + graph[k][j]){
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }
                    }
                }
            }
        }
    }
}
