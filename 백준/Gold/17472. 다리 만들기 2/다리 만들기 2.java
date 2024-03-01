import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 간선 클래스
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static int N, M, edgeCount;
    static int[] parent, rank;
    static int[][] graph, map;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Input
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j * 2) - '0';
                // 섬을 -1로 초기화
                if (map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }// Input End

        // 고유 번호 부여
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) {
                    edgeCount++;
                    dfs(i, j);
                }
            }
        }// 고유 번호 부여 끝

        // 그래프 생성
        graph = new int[edgeCount + 1][edgeCount + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int nX = i + dirX[k];
                        int nY = j + dirY[k];
                        if (isIn(nX, nY) && map[nX][nY] == 0) {
                            getDist(nX, nY, k, map[i][j], 1);
                        }
                    }
                }
            }
        } // 그래프 생성 끝


        // 우선 순위 큐에 0이 아닌 모든 간선을 넣어준다.
        PriorityQueue<Edge> edgeList = new PriorityQueue<>();
        for (int i = 1; i <= edgeCount; i++) {
            for (int j = 1; j <= edgeCount; j++) {
                if (graph[i][j] != 0) {
                    edgeList.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        // 자기 자신을 가르키는 원소를 만든다.
        makeSet();

        int answer = 0;
        int count = 0;
        while (count < edgeCount - 1) {
            if (edgeList.isEmpty()) {
                answer = -1;
                break;
            }

            Edge e = edgeList.poll();
            if (!union(e.from, e.to)) {
                continue;
            }
            answer += e.weight;
            count++;
        }
        System.out.println(answer);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b){
            return false;
        }

        if(rank[a] > rank[b]){
            parent[b] = a;
            rank[a] += rank[b];
        }else{
            parent[a] = b;
            rank[b] += rank[a];
        }
        return true;
    }

    private static void makeSet() {
        // 자신을 가르키는 트리를 만듬
        parent = new int[edgeCount + 1];
        rank = new int[edgeCount + 1];
        for (int i = 1; i <= edgeCount; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private static void getDist(int x, int y, int d, int from, int dist) {
        if (map[x][y] == 0) {
            if (isIn(x + dirX[d], y + dirY[d])) {
                getDist(x + dirX[d], y + dirY[d], d, from, dist + 1);
            }
        }
        // 다른 섬이라면
        else if (map[x][y] != from) {
            // 길이가 1이면 안된다.
            if (dist - 1 <= 1) {
                return;
            }

            int idx = map[x][y];
            if (graph[from][idx] == 0 || graph[from][idx] > dist - 1) {
                graph[from][idx] = graph[idx][from] = dist - 1;
            }
        }
    }

    // 섬에 고유 번호를 부여한다.
    private static void dfs(int x, int y) {
        map[x][y] = edgeCount;
        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if (isIn(nX, nY) && map[nX][nY] == -1) {
                dfs(nX, nY);
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
