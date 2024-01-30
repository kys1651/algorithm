import java.util.*;
import java.io.*;

// 한 도시에서 다른 도시 최소비용 -> 다익스트라(dijkstra)
public class Main {
    // 노드 클래스. 가중치와 인덱스를 가지고 있음
    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    // 각 노드가 연결된 노드 리스트
    static ArrayList<Node>[] graph;
    // 노드의 개수
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        // for문을 통해서 직접 초기화해주어야한다.
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // m : 간선의 개수
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()); // 출발지
            int to = Integer.parseInt(st.nextToken()); // 도착지
            int cost = Integer.parseInt(st.nextToken()); // 가중치
            graph[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
    }

    // start부터 end까지 걸리는 최소 비용을 구하는 다익스트라 알고리즘
    private static void dijkstra(int start, int end) {
        // 우선순위큐 -> 코스트가 가장 낮은 노드가 우선순위
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        // 시작지점을 코스트를 0으로하여 넣어준다.
        queue.offer(new Node(start, 0));

        // 방문한 곳은 다시 방문하지 않기에 visit 배열을 생성해준다.
        boolean[] visit = new boolean[n + 1];

        // 비용을 저장하기 위한 cost 배열
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE); // 최소비용을 찾기 위해서 MAX_VALUE를 넣어준다.
        // 시작지점 비용은 0이다.
        cost[start] = 0;

        while (!queue.isEmpty()) {
            // 현재 노드: 현재 갈 수 있는 방문안한 노드 중 비용이 가장 싼 곳
            Node current = queue.poll();

            if (visit[current.idx]) {
                continue;
            }
            visit[current.idx] = true;
            // 현재 노드와 연결된 노드들을 차례대로 빼준다.
            for (Node nextCity : graph[current.idx]) {
                // 다음 도시로 가는 기존 비용이 현재 노드에서 가는 비용보다 싸다면
                if (cost[nextCity.idx] > cost[current.idx] + nextCity.cost) {
                    // 값을 넣어준다.
                    cost[nextCity.idx] = cost[current.idx] + nextCity.cost;
                    // 갱신 후 큐에 넣어준다.
                    queue.offer(new Node(nextCity.idx, cost[nextCity.idx]));
                }
            }
        }

        // 출력 후 종료 -> 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
        System.out.println(cost[end]);
    }
}