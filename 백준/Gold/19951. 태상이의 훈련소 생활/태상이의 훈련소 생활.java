import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] h = new int[N + 1];

        // Input
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }// Input End

        int[] sum = new int[N + 2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sum[s] += k;
            sum[e + 1] += (-k);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + sum[i];
            h[i] += sum[i];
            sb.append(h[i]).append(' ');
        }
        System.out.println(sb);
    }
}