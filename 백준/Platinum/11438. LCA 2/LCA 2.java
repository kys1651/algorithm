import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] list;
    private static int[][] parent;
    private static int[] depth;
    private static int N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        // Init
        N = Integer.parseInt(br.readLine());
        init();

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        } // Init End

        // 높이 구하기
        H = (int) (Math.ceil(Math.log(N) / Math.log(2)));
        depth = new int[N + 1];
        parent = new int[N + 1][H + 1];

        // 1번(루트)노드 부터 갱신
        init(1, 1, 0);
        fillParent();

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append('\n');
        }
        System.out.println(sb);
    }

    private static void init() {
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
    }

    private static int LCA(int a, int b) {
        // 항상 A의 높이가 더 높도록 한다.
        if(depth[a] < depth[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 높이를 맞춘다.
        for (int i = H; i >= 0; i--) {
            if(Math.pow(2,i) <= depth[a] - depth[b]){
                a = parent[a][i];
            }
        }

        if(a == b) return a;

        // LCA를 찾는다. -> 2승씩 올리면서 공통 노드의 바로 아래까지 위치시켜준다.
        for (int i = H - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }

    private static void fillParent() {
        // DP를 이용하여 각 노드의 2^K 조상 노드를 저장
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }

    private static void init(int curIdx, int h, int parentIdx) {
        depth[curIdx] = h; // 현재 높이 갱신
        for (int next : list[curIdx]) {
            if(next == parentIdx) continue; // 부모 노드로부터 왔다면 갈 필요 X 트리 특성상 경로는 1개
            init(next, h + 1, curIdx);
            parent[next][0] = curIdx; // 0번째 인덱스란 현재 부모노드 저장
        }
    }
}
