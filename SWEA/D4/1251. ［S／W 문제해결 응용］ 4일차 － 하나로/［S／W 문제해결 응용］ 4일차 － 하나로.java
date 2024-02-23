import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static class Island {
        double x;
        double y;
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

    static Island[] islands;
    static int[] parents, rank;
    static int N;
    static double E;
    static PriorityQueue<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            islands = new Island[N];
            // Input
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i] = new Island();
                islands[i].x = Double.parseDouble(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i].y = Double.parseDouble(st.nextToken());
            }
            // Input End
            E = Double.parseDouble(br.readLine());

            // 엣지 생성
            make();

            int count = 0;
            double weight = 0;
            while (count != N - 1) {
                Edge e = edgeList.poll();
                if (!union(e.from, e.to)) {
                    continue;
                }
                weight += e.weight;
                count++;
            }
            sb.append(String.format("#%d %.0f\n", tc, weight));
        }
        System.out.println(sb);
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
        if (a == b) {
            return false;
        }

        if (rank[a] > rank[b]) {
            parents[b] = a;
            rank[a] += rank[b];
        } else {
            parents[a] = b;
            rank[b] += rank[a];
        }
        return true;
    }

    private static void make() {
        edgeList = new PriorityQueue<>();
        parents = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            rank[i] = 1;
            for (int j = i + 1; j < N; j++) {
                edgeList.add(new Edge(i, j, getWeight(islands[i], islands[j])));
            }
        }
    }

    private static double getWeight(Island i, Island j) {
        double x = Math.pow(i.x - j.x, 2);
        double y = Math.pow(i.y - j.y, 2);
        double L = Math.sqrt(x + y);
        return L * L * E;
    }
}