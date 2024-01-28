import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] num;
    static int[] result = new int[6];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            combination(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // N개 중 6개를 뽑는 숫자
    private static void combination(int depth,int at) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < n; i++) {
            result[depth] = num[i];
            combination(depth + 1, i + 1);
        }
    }
}