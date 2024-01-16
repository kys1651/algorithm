import java.util.*;
import java.io.*;

public class Main {
    // 도시 노선의 정보를 담는 배열
    static int[][] graph;
    // 도시의 개수
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 도시 개수 입력 받기
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        // 최소값을 찾기 위해 비용의 최대값 100,000 * 최대 도시 100값으로 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], 10000000);
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            // 노선의 개수는 한개가 아닐수도 있기 때문에 처음 받는 값이 아니라면 최소값 삽입
            if (graph[from][to] > value) {
                graph[from][to] = value;
            }
        }

        // 플로이드 워셜
        floydWarshall();

        // sb에 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || graph[i][j] == 10000000) graph[i][j] = 0;
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 모든 노드를 거쳐가는 플로이드워셜 알고리즘
    private static void floydWarshall() {
        // 거쳐가는 도시
        for (int k = 0; k < n; k++) {
            // 출발 도시
            for (int i = 0; i < n; i++) {
                // 도착 도시
                for (int j = 0; j < n; j++) {
                    // 더 빠른 노선이 있다면 그것으로 초기화 시켜줌
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}
