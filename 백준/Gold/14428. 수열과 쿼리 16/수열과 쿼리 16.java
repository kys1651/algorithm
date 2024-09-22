import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class SegmentTree {
        int len;
        int height;
        int[] tree;
        int[] arr;

        public SegmentTree(int n, int[] arr) {
            int size = (int) (Math.ceil(Math.log(n) / Math.log(2)));
            len = 1 << size;
            height = 1 << (size + 1);

            this.arr = arr;
            tree = new int[height];
            init(n);
        }

        private void init(int n) {
            for (int i = 1; i <= n; i++) tree[len + i] = i;
            for (int i = len - 1; i >= 1; i--) tree[i] = compare(tree[i * 2], tree[i * 2 + 1]);
        }

        public void update(int idx, int newValue) {
            arr[idx] = newValue;
            idx += len;
            idx /= 2;
            while (idx >= 1) {
                tree[idx] = compare(tree[idx * 2], tree[idx * 2 + 1]);
                idx /= 2;
            }
        }

        public int query(int idx, int s, int e, int ts, int te) {
            if(s > te || e < ts) return 0; // 범위밖이면 0
            else if (ts <= s && e <= te) return tree[idx]; // 범위에 포함되면 최소값 인덱스 리턴
            int mid = (s + e) >> 1;
            return compare(query(2 * idx, s, mid, ts, te), query(idx * 2 + 1, mid + 1, e, ts, te));
        }

        private int compare(int leftIdx, int rightIdx) {
            if (leftIdx == 0 || rightIdx == 0) return leftIdx == 0 ? rightIdx : leftIdx;
            int leftValue = arr[leftIdx];
            int rightValue = arr[rightIdx];
            return (leftValue == rightValue) ? Math.min(leftIdx, rightIdx)
                    : (leftValue > rightValue) ? rightIdx : leftIdx;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        SegmentTree segmentTree = new SegmentTree(n, arr);

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if (command == 1) {
                segmentTree.update(i, j);
            } else {
                sb.append(segmentTree.query(1, 0, segmentTree.len - 1, i, j)).append('\n');
            }
        }
        System.out.println(sb);
    }
}