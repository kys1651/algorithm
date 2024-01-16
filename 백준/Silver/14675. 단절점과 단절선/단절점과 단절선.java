import java.util.*;
import java.io.*;

public class Main {
    static int[] nodes;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        nodes = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a]++;
            nodes[b]++;
        }
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (n == 1) {
                sb.append("no");
            } else if (t == 2) {
                sb.append("yes");
            } else if (nodes[k] <= 1){
                sb.append("no");
            }else{
                sb.append("yes");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
