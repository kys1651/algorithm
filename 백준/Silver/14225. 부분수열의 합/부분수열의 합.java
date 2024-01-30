import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] num;
    static boolean[] check = new boolean[100000 * 20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0);

        int idx = 1;
        while(check[idx]){
            idx++;
        }
        System.out.println(idx);
    }

    private static void combination(int depth,int sum) {
        if (depth == n) {
            check[sum] = true;
            return;
        }
        combination(depth + 1, sum + num[depth]);
        combination(depth + 1, sum);
    }
}