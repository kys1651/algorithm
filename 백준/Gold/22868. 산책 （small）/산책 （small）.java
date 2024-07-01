import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    static Node[] graph;
    static int[] prev;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new Node[N + 1];

        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            addNode(from, to);
            addNode(to, from);
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int count = 0;

        prev = new int[N + 1];
        getCount(s, e);
        for (int idx = e; prev[idx] != idx; idx = prev[idx]) {
            visit[idx] = true;
            count++;
        }
        visit[s] = visit[e] = false;
        prev = new int[N + 1];

        getCount(e, s);
        for (int idx = s; prev[idx] != idx; idx = prev[idx]) {
            count++;
        }
        System.out.println(count);
    }

    private static void getCount(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        prev[s] = s;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node next = graph[cur]; next != null; next = next.next) {
                if (visit[next.idx] || prev[next.idx] != 0) {
                    continue;
                }
                prev[next.idx] = cur;
                queue.add(next.idx);
                if (next.idx == e) {
                    break;
                }
            }
        }
    }

    private static void addNode(int from, int to) {
        if (graph[from] == null || graph[from].idx > to) {
            graph[from] = new Node(to, graph[from]);
        } else {
            Node current = graph[from];
            while (current.next != null && current.next.idx < to) {
                current = current.next;
            }
            current.next = new Node(to, current.next);
        }
    }
}