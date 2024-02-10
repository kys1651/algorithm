import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 문제: Main_1167_트리의지름
 * @author 김용수
 * 제출한 시간: 2024년 2월 11일 02:20:13
 * 메모리: 111224KB
 * 시간: 944ms
 *
 * 접근 방법
 * 1. 트리의 지름을 구하기 위해서는 아무한 노드에서 시작점을 잡고 DFS를 돌려 가장 긴 거리를 찾으면 된다.
 * -> 가장 긴 거리에서 한번 더 DFS를 돌려야 가장 긴 지름을 찾을 수 있기 때문에
 * 2. Well-Known 문제이기 때문에 설명 생략
 */
public class Main {
    // 노드의 정보를 담는 클래스
    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    // 그래프를 ArrayList로 표현
    static LinkedList<Node>[] graph;
    static boolean[] visit;
    static int max, maxNodeIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break;
                int value = Integer.parseInt(st.nextToken());
                graph[from].add(new Node(next, value));
            }
        }

        visit = new boolean[N+1];
        maxNodeIdx = 1;
        max = 0;
        dfs(maxNodeIdx, 0);

        visit = new boolean[N+1];
        dfs(maxNodeIdx, 0);

        System.out.println(max);
    }

    private static void dfs(int node, int cost) {
        visit[node] = true;
        if (cost > max) {
            max = cost;
            maxNodeIdx = node;
        }

        for (Node next : graph[node]) {
            if (visit[next.idx]) continue;
            dfs(next.idx, cost + next.value);
        }
    }
}