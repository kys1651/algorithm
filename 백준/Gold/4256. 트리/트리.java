import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] pre, in;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            pre = new int[n];
            in = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 전위 순회 저장
            for (int i = 0; i < n; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }
            // 중위순회 저장
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                in[i] = Integer.parseInt(st.nextToken());
            }
            postOrder(0,0,n);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 후위 순회 (LRV)
    private static void postOrder(int r,int start, int end) {
        for (int i = start; i < end; i++) {
            if(pre[r] == in[i]){ // Root 값 발견
                postOrder(r + 1, start, i);
                postOrder(r + i - start + 1, i + 1, end);
                sb.append(pre[r]).append(" ");
                return;
            }
        }
    }
}
