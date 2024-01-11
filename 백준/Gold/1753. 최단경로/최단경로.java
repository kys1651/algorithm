import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Node{
        int idx;
        int weight;

        Node(int idx,int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
    static ArrayList<Node>[] list;
    static int[] value;
    static int v,e, start;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 개수
        v = Integer.parseInt(st.nextToken());
        // 간선의 개수
        e = Integer.parseInt(st.nextToken());
        // 시작 노드의 번호
        start = Integer.parseInt(br.readLine());
        // 가중치들을 저장하기 위한 배열
        value = new int[v + 1];
        Arrays.fill(value, Integer.MAX_VALUE);
        // 연결된 노드들을 저장하기 위해서 ArrayList 배열을 생성하여준다.
        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
        }
        // 최단 경로 갱신
        dijkstra();

        for (int i = 1; i <= v; i++) {
            // 만약 value[i] 값이 Integer.MAX_VALUE라면 방문 할 수 없는 곳
            if(value[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(value[i]);
            }
        }
    }

    // 최단 경로 알고리즘 다익스트라(Dijkstra)
    private static void dijkstra() {
        // 현재 갈 수 있는 방문하지 않는 노드 중에서 최소 가중치를 가진 곳을 찾아야하기 때문에 우선순위 큐를 사용한다.
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
        // 출발 노드 설정
        queue.offer(new Node(start, 0));

        // 방문 처리를 할 visit 배열
        boolean[] visit = new boolean[v + 1];
        // 출발 노드의 비용은 0으로 설정한다.
        value[start] = 0;

        while (!queue.isEmpty()) {
            // 현재 노드를 기준으로 방문했다면 넘어가준다.
            Node node = queue.poll();
            if(visit[node.idx]) continue;
            visit[node.idx] = true;

            // 방문하지 않는 노드가 갈 수 있는 노드들
            for (Node nextNode : list[node.idx]) {
                int end = nextNode.idx;
                int weight = nextNode.weight;
                // 현재 노드 기준으로 갈 수 있는 경로가 더 싸다면 갱신 해준다.
                if (value[end] > value[node.idx] + weight) {
                    value[end] = value[node.idx] + weight;
                    queue.add(new Node(end, value[end]));
                }
            }
        }
    }
}