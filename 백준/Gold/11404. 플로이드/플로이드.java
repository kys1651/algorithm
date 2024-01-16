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
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            // 노선의 개수는 한개가 아닐수도 있기 때문에 처음 받는 값이 아니라면 최소값 삽입
            if (graph[from][to] != 0) {
                graph[from][to] = Math.min(graph[from][to], value);
            }else{
                graph[from][to] = value;
            }

        }

        // 플로이드 워셜
        floydWarshall();

        // sb에 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) graph[i][j] = 0;
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
                    // i -> k 노선 연결 && k -> j 노션 연결인 경우
                    if (graph[i][k] != 0 && graph[k][j] != 0) {
                        // 기존 노선이 연결되지 않은 경우
                        if(graph[i][j] == 0){
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }
                        // 기존에 이미 노선이 있는 경우 최소값 연결
                        else if(graph[i][j] > graph[i][k] + graph[k][j]){
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }
                    }
                }
            }
        }
    }
}
