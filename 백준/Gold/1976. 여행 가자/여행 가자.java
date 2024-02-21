import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent; // 부모 인덱스가 담긴 배열
    static int[] rank; // rank를 담는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 각 원소가 하나인 노드를 생성
        makeSet(N);

        // Input
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int isLink = Integer.parseInt(st.nextToken());
                if (isLink == 1) {
                    union(i, j);
                }
            }
        }// Input End

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 첫번째 원소의 루트와 다른 곳 == 집합이 다른 곳 즉, 올 수 없음
        int root = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            if (root != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }

        if (rank[a] > rank[b]) {
            parent[b] = a;
            rank[a] += rank[b];
        } else {
            parent[a] = b;
            rank[b] += rank[a];
        }
    }

    private static void makeSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
}