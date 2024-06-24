import java.util.*;
import java.io.*;

class Main {
    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static int[] rank, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;

            init();

            PriorityQueue<Edge> queue = new PriorityQueue<>();
            int total = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                total += cost;
                queue.add(new Edge(from, to, cost));
            }

            int count = 0;
            int minCost = 0;
            while (count < N - 1) {
                Edge e = queue.poll();

                if (union(e.a, e.b)) {
                    minCost += e.cost;
                    count++;
                }
            }

            sb.append(total - minCost).append('\n');
        }

        System.out.println(sb);
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;

        if(rank[a] > rank[b]){
            rank[a] += rank[b];
            parent[b] = a;
        }else{
            rank[b] += rank[a];
            parent[a] = b;
        }
        return true;
    }

    private static void init() {
        rank = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }
}