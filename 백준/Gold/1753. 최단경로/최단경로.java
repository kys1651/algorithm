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
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        value = new int[v + 1];
        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(value, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
        }
        bfs();
        for (int i = 1; i <= v; i++) {
            if(value[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(value[i]);
            }
        }
    }

    private static void bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
        queue.offer(new Node(start, 0));
        boolean[] visit = new boolean[v + 1];
        value[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(visit[node.idx]) continue;
            visit[node.idx] = true;

            for (Node nextNode : list[node.idx]) {
                int end = nextNode.idx;
                int weight = nextNode.weight;

                if (value[end] > value[node.idx] + weight) {
                    value[end] = value[node.idx] + weight;
                    queue.add(new Node(end, value[end]));
                }
            }
        }
    }
}