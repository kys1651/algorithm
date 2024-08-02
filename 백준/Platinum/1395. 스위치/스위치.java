import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Segment {
    int size;
    int[] lazy;
    int[] tree;

    public Segment(int n) {
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        this.size = (int) Math.pow(2, height + 1);
        this.lazy = new int[this.size];
        this.tree = new int[this.size];
    }

    public void updateLazy(int idx, int s, int e) {
        if (lazy[idx] % 2 == 1) {
            if (s != e) {
                lazy[idx * 2] += lazy[idx];
                lazy[idx * 2 + 1] += lazy[idx];
            }
            tree[idx] = (e - s + 1) - tree[idx];
            lazy[idx] = 0;
        }
    }

    public void update(int idx, int s, int e, int ts, int te) {
        updateLazy(idx, s, e);

        if (te < s || e < ts) return;
        if (ts <= s && e <= te) {
            lazy[idx] = 1;
            updateLazy(idx, s, e);
            return;
        }
        int mid = (s + e) / 2;
        update(idx * 2, s, mid, ts, te);
        update(idx * 2 + 1, mid + 1, e, ts, te);
        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }

    public int query(int idx, int s, int e, int ts, int te) {
        updateLazy(idx, s, e);
        if (te < s || e < ts) return 0;
        if (ts <= s && e <= te) {
            return tree[idx];
        }
        int mid = (s + e) / 2;
        return query(idx * 2, s, mid, ts, te) + query(idx * 2 + 1, mid + 1, e, ts, te);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Segment segment = new Segment(n);
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (c == 0) {
                segment.update(1, 1, n, a, b);
            } else {
                int query = segment.query(1, 1, n, a, b);
                sb.append(query).append('\n');
            }
        }
        System.out.println(sb);
    }
}