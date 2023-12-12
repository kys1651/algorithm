import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int destination;
        int dist;

        public Node(int destination, int dist){
            this.destination = destination;
            this.dist = dist;
        }
    }
    static List<Node>[] lists;
    static boolean[] visit;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        lists = new ArrayList[a + 1];
        for(int i = 1; i <= a; i++){
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < a - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lists[x].add(new Node(y, v));
            lists[y].add(new Node(x, v));
        }
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());
            visit = new boolean[a + 1];
            sb.append(dfs(start, goal) + "\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int pos, int goal) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(pos, 0));
        visit[pos] = true;

        int dist = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.destination == goal) {
                dist =  node.dist;
                break;
            }

            for(Node tmp:lists[node.destination]){
                if (!visit[tmp.destination]) {
                    q.offer(new Node(tmp.destination, node.dist + tmp.dist));
                    visit[tmp.destination] = true;
                }
            }
        }
        return dist;
    }
}