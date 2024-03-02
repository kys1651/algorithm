import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent, rank;

    static class Edge implements Comparable<Edge>{
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        makeSet(N);

        PriorityQueue<Edge> edgeList = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(from, to, weight));
        }

        int count = 0;
        int answer = 0;
        int maxCount = 0;
        while (count < N - 1) {
            Edge edge = edgeList.poll();
            if (!union(edge.from, edge.to)) {
                continue;
            }
            answer += edge.weight;
            count++;
            maxCount = Math.max(maxCount, edge.weight);
        }
        System.out.println(answer - maxCount);
    }

    private static int find(int a){
        if(parent[a] == a){
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
        if (rank[a] > rank[b]) {
            rank[a] += rank[b];
            parent[b] = a;
        }else{
            rank[b] += rank[a];
            parent[a] = b;
        }
        return true;
    }

    private static void makeSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
}
