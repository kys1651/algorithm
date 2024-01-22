import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int[] in,post;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }
        preOrder(n - 1, n - 1, 0);
        System.out.println(sb);
    }
    private static void preOrder(int r,int s, int e){
        if(s < e) return;
        sb.append(post[r] + " ");


        for (int i = s; i >= e; i--) {
            // 루트 노드 발견시
            if(in[i] == post[r]){
                // VLR이므로
                // Left 집합 먼저 호출
                preOrder(r - (s - i + 1), i - 1, e);
                // Right 집합 호출
                preOrder(r - 1, s, i + 1);
                return;
            }
        }
    }
}
