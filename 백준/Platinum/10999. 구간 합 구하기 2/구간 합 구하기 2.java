import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SegmentTree {
    int size;
    int len;
    long[] lazy;
    long[] tree;

    public SegmentTree(int n) {
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        this.size = (int) Math.pow(2, height + 1);
        this.len = (int) Math.pow(2, height);

        lazy = new long[size];
        tree = new long[size];
    }

    public void init(int idx, int s, int e, long[] a) {
        if (s == e) {
            tree[idx] = a[s];
            return;
        }
        int mid = (s + e) / 2;
        init(idx * 2, s, mid, a);
        init(idx * 2 + 1, mid + 1, e, a);
        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }

    public long query(int idx, int s, int e, int ts, int te) {
        updateLazy(idx, s, e);
        if (e < ts || te < s) return 0;
        if (ts <= s && e <= te) return tree[idx];

        int mid = (s + e) / 2;
        return query(idx * 2, s, mid, ts, te) + query(idx * 2 + 1, mid + 1, e, ts, te);
    }

    public void update(int idx, int s, int e, int ts, int te, long diff) {
        updateLazy(idx, s, e);
        if (e < ts || s > te) return;
        if (ts <= s && e <= te) {
            tree[idx] += (e - s + 1) * diff;
            if (s != e) {
                lazy[idx * 2] += diff;
                lazy[idx * 2 + 1] += diff;
            }
            return;
        }

        int mid = (s + e) / 2;
        update(idx * 2, s, mid, ts, te, diff);
        update(idx * 2 + 1, mid + 1, e, ts, te, diff);
        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }

    public void updateLazy(int idx, int s, int e) {
        if (lazy[idx] != 0) {
            tree[idx] += lazy[idx] * (e - s + 1);
            if (s != e) {
                lazy[idx * 2] += lazy[idx];
                lazy[idx * 2 + 1] += lazy[idx];
            }
            lazy[idx] = 0;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // Input
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }// Input End

        SegmentTree tree = new SegmentTree(n);
        tree.init(1, 0, n - 1, arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (command == 1) {
                long c = Long.parseLong(st.nextToken());
                tree.update(1, 0, n - 1, a, b, c);
            } else {
                long total = tree.query(1, 0, n - 1, a, b);
                sb.append(total).append('\n');
            }
        }
        System.out.println(sb);
    }
}