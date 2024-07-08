import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class SegmentTree {
        int size;
        long[] tree;

        public SegmentTree(int size) {
            int h = (int) Math.ceil(Math.log(size) / Math.log(2));
            this.size = (int) Math.pow(2, h + 1);
            this.tree = new long[this.size];
        }

        public long init(long[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];

            int mid = (start + end) / 2;
            return tree[node] = (init(arr, node * 2, start, mid) * init(arr, node * 2 + 1, mid + 1, end)) % MOD;
        }

        public long query(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 1;
            if (left <= start && end <= right) return tree[node];
            int mid = (start + end) / 2;
            return (query(node * 2, start, mid, left, right) * query(node * 2 + 1, mid + 1, end, left, right)) % MOD;
        }

        public long update(int node, int start, int end, int idx, long newValue) {
            if (idx < start || end < idx) return tree[node];
            if (start == end) return tree[node] = newValue;

            int mid = (start + end) / 2;
            return tree[node] = (update(node * 2, start, mid, idx, newValue) * update(node * 2 + 1, mid + 1, end, idx, newValue)) % MOD;
        }
    }

    public static final Long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(arr, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                arr[b] = c;
                segmentTree.update(1, 1, N, b, c);
            } else {
                sb.append(segmentTree.query(1, 1, N, b, c)).append('\n');
            }
        }
        System.out.println(sb);
    }
}