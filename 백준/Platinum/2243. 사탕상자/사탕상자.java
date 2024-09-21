import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class SegmentTree {
        int height;
        int len;
        int[] tree;

        public SegmentTree(int n) {
            len = 1 << n;
            height = len * 2;
            tree = new int[height];
        }

        public void update(int idx, int diff) {
            idx += len;
            tree[idx] += diff;
            idx /= 2;
            while (idx >= 1) {
                tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
                idx /= 2;
            }
        }

        public int query(int idx, int s, int e, int target) {
            // 같으면 발견한 것 -1 감소 후 값 리턴
            if (s == e) {
                update(s, -1);
                return s;
            }

            int mid = (s + e) >> 1;
            if (target <= tree[idx * 2]) {
                return query(idx * 2, s, mid, target);
            } else {
                return query(idx * 2 + 1, mid + 1, e, target - tree[idx * 2]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int size = 20;
        SegmentTree segmentTree = new SegmentTree(size);

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            if (command == 1) { // 1이면 a번째 찾기
                sb.append(segmentTree.query(1, 0, segmentTree.len - 1, a)).append('\n');
            }
            else { // 2면 a맛 사탕 b만큼 추가
                int b = Integer.parseInt(st.nextToken());
                segmentTree.update(a, b);
            }
        }
        System.out.println(sb);

    }
}