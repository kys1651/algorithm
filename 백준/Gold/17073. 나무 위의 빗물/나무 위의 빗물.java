import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double w = Double.parseDouble(st.nextToken());
        int[] tree = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u]++;
            tree[v]++;
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if(tree[i] == 1){
                count++;
            }
        }
        System.out.println(w / count);
    }
}
