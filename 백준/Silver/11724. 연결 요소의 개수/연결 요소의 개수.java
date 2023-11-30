import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = 1;
        }
        int result = 0;
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                result++;
                // 연결된 노드를 방문처리
                bfs(i);
            }
        }
        System.out.println(result);
    }

    private static void bfs(int start) {
        // start 노드 방문
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        // q가 빈다는건 연결된 요소가 없다는 것
        while (!q.isEmpty()) {
            // 현재 요소를 빼줌
            int cur = q.poll();
            // 현재 요소와 연결된 노드를 확인
            for(int i = 1; i< graph[cur].length; i++){
                // 연결된 곳 중 방문하지 않은 곳이 있을 때
                if(graph[cur][i] == 1 && !visited[i]){
                    // 방문 처리 후 큐에 삽입
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}