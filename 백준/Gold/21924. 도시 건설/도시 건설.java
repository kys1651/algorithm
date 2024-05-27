import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        long cost;

        public Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.cost - o.cost);
        }
    }

    static int[] parent, rank;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Integer.parseInt(st.nextToken());
            sum += cost;

            queue.add(new Edge(from, to, cost));
            queue.add(new Edge(to, from, cost));
        }

        init();
        int count = 0;
        long totalCost = 0;
        while (count != N - 1 && !queue.isEmpty()) {
            Edge edge = queue.poll();

            if (!union(edge.from, edge.to)) {
                continue;
            }

            count++;
            totalCost += edge.cost;
        }

        if (count == N - 1) {
            System.out.println(sum - totalCost);
        } else {
            System.out.println(-1);
        }
    }

    private static void init() {
        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    private static int getParent(int a) {
        if (parent[a] == a) return a;
        return parent[a] = getParent(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) {
            return false;
        }

        if (rank[a] > rank[b]) {
            parent[b] = a;
            rank[a] += rank[b];
        } else {
            parent[a] = b;
            rank[b] += rank[a];
        }
        return true;
    }
}