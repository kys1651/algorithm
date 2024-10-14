import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class SegmentTree {
        int[] tree;
        int size;
        int len;

        public SegmentTree(int n, int m) {
            int h = (int) (Math.log(n + m) / Math.log(2));
            len = 1 << (h + 1);
            size = len * 2;
            tree = new int[size];
            for (int i = 0; i < n; i++) {
                tree[len + i] = 1;
            }

            for (int i = len - 1; i >= 1; i--) {
                tree[i] = tree[2 * i] + tree[2 * i + 1];
            }
        }

        public int query(int idx, int s, int e, int ts, int te) {
            if (s > te || e < ts) return 0;
            else if (ts <= s && e <= te) return tree[idx];

            int mid = (s + e) >> 1;
            return query(2 * idx, s, mid, ts, te) + query(2 * idx + 1, mid + 1, e, ts, te);
        }

        public void update(int idx, int val) {
            idx += len;
            tree[idx] = val;
            idx >>= 1;
            while (idx != 1) {
                tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
                idx >>= 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] idx2idx = new int[N];
            SegmentTree segmentTree = new SegmentTree(N, M);
            for (int i = 0; i < N; i++) {
                idx2idx[N - i - 1] = i;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                int idx = idx2idx[num - 1];
                idx2idx[num - 1] = N + i;
                int sum = segmentTree.query(1, 0, segmentTree.len - 1, idx + 1, N + M);
                sb.append(sum).append(' ');
                segmentTree.update(idx, 0);
                segmentTree.update(idx2idx[num - 1], 1);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
