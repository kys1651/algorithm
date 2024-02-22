import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static PriorityQueue<Edge> edgeList = new PriorityQueue<>();
    static Star[] star;
    static int[] parents;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        star = new Star[N + 1];
        parents = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            star[i] = new Star(x, y);
            parents[i] = i;
            rank[i] = 1;
        }

        make(N);

        int count = 0;
        double weight = 0;
        while (count != N - 1) {
            Edge edge = edgeList.poll();
            if (!union(edge.from, edge.to)) {
                continue;
            }
            weight += edge.weight;
            count++;
        }
        System.out.printf("%.2f",weight);
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;

        if (rank[a] > rank[b]) {
            parents[b] = a;
            rank[a] += rank[b];
        } else {
            parents[a] = b;
            rank[b] += rank[a];
        }
        return true;
    }

    private static void make(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edgeList.add(new Edge(i, j, getDistance(star[i], star[j])));
            }
        }
    }

    private static double getDistance(Star a, Star b) {
        return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
    }
}