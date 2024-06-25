import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static class Node{
        int idx;
        Node next;

        public Node(int idx, Node next) {
            this.idx = idx;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] outDegree = new int[N + 1];
        Node[] graph = new Node[N + 1];

        // Input
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            graph[to] = new Node(from, graph[to]);
            outDegree[from]++;
        }// Input End

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(outDegree[i] == 0) queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append(' ');
            for (Node tmp = graph[cur]; tmp != null; tmp = tmp.next) {
                outDegree[tmp.idx]--;
                if(outDegree[tmp.idx] == 0) queue.add(tmp.idx);
            }
        }
        for (int i = 1; i <= N; i++) {
            if(outDegree[i] != 0) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}