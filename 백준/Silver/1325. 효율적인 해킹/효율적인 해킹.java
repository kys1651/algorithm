import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] answer;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = nextInt();
        int M = nextInt();
        visit = new boolean[N + 1];
        answer = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = nextInt();
            int v = nextInt();
            graph[u].add(v);
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visit,false);
//            bfs(i);
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (answer[i] > max) max = answer[i];
        }

        for (int i = 1; i <= N; i++) {
            if (answer[i] == max)
                sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    //    private static void bfs(int node) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(node);
//        visit[node] = true;
//
//        while (!queue.isEmpty()) {
//            int cur = queue.poll();
//
//            for (int next : graph[cur]) {
//                if (visit[next]) continue;
//                answer[next]++;
//                visit[next] = true;
//                queue.add(next);
//            }
//        }
//    }
    static void dfs(int node) {
        visit[node] = true;
        for (int next : graph[node]) {
            if (visit[next]) continue;
            answer[next]++;
            dfs(next);
        }
    }

    static int nextInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}