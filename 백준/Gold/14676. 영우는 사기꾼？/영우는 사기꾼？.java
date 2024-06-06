import java.io.*;
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
    static int[] inDegree, created;
    static final String CHEAT = "Lier!";
    static final String NO_CHEAT = "King-God-Emperor";

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Input
        inDegree = new int[N + 1];
        created = new int[N + 1];
        graph = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, graph[from]);
            inDegree[to]++;
        }// Input

        boolean answer = true;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            // 건물 건설
            if (command == 1 && !createBuilding(idx)) {
                answer = false;
                break;
            }
            // 건물 파괴
            else if (command == 2 && !destroyBuilding(idx)) {
                answer = false;
                break;
            }
        }

        System.out.println(answer ? NO_CHEAT : CHEAT);
    }

    private static boolean destroyBuilding(int idx) {
        if (created[idx] == 0) return false;

        created[idx]--;
        if (created[idx] == 0) {
            for (Node tmp = graph[idx]; tmp != null; tmp = tmp.next) {
                inDegree[tmp.idx]++;
            }
        }

        return true;
    }

    private static boolean createBuilding(int idx) {
        if (inDegree[idx] != 0) return false;

        created[idx]++;
        if (created[idx] == 1) {
            for (Node tmp = graph[idx]; tmp != null; tmp = tmp.next) {
                inDegree[tmp.idx]--;
            }
        }
        return true;
    }
}