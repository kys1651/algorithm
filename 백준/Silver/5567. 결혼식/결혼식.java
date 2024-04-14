import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        Node next;

        public Node(int idx, Node next) {
            this.idx = idx;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] graph = new Node[N + 1];
        int M = Integer.parseInt(br.readLine());

        // Input
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, graph[from]);
            graph[to] = new Node(from, graph[to]);
        }// Input End

        boolean[] visit = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (visit[cur[0]]) continue;
            visit[cur[0]] = true;
            if (cur[1] == 2) continue;
            for (Node tmp = graph[cur[0]]; tmp != null; tmp = tmp.next) {
                if (visit[tmp.idx]) continue;
                queue.add(new int[]{tmp.idx, cur[1] + 1});
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if(visit[i]) answer++;
        }
        System.out.println(answer - 1);
    }
}
