import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class SegmentTree {
        private long tree[];
        private int treeSize;

        public SegmentTree(int size) {
            int h = (int) Math.ceil(Math.log(size) / Math.log(2)); // 높이

            this.treeSize = (int) Math.pow(2, h + 1);
            this.tree = new long[treeSize];
        }

        public long init(long[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            }

            int mid = (start + end) / 2;
            return tree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid + 1, end);
        }

        public void update(int node, int start, int end, int idx, long diff) {
            if (idx < start || end < idx) return;

            tree[node] += diff;

            if (start != end) {
                int mid = (start + end) / 2;
                update(node * 2, start, mid, idx, diff);
                update(node * 2 + 1, mid + 1, end, idx, diff);
            }
        }

        public long query(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            return query(node * 2, start, mid, left, right) +
                    query(node * 2 + 1, mid + 1, end, left, right);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Long.parseLong(br.readLine());

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(arr, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                segmentTree.update(1, 1, N, b, c - arr[b]);
                arr[b] = c;
            } else {
                sb.append(segmentTree.query(1, 1, N, b, (int) c)).append('\n');
            }
        }
        System.out.println(sb);
    }
}