import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        // 인접행렬을 받기 위한 배열
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 플로이드 워셜 알고리즘
        // 거쳐가는 노드
        for (int k = 0; k < n; k++) {
            // 출발 노드
            for (int i = 0; i < n; i++) {
                // 도착 노드
                for (int j = 0; j < n; j++) {
                    // i에서 k를 거친 뒤 k 에서 j를 거쳐 갈 수 있는 경로가 존재하는가? 존재한다면 연결
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
