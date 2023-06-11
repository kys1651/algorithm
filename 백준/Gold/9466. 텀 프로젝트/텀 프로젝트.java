import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int[] arr;
    static int count,n;
    static boolean[] checked;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n+1];
            checked = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                dfs(i);
            }

            sb.append(n - count).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int idx) {
        if (checked[idx]) {
            return;
        }

        // 방문 했다고 표시
        checked[idx] = true;
        // idx번째 학생이 지목한 idx 구하기
        int select = arr[idx];

        // 방문 안한 학생이라면
        if (!checked[select]) {
            dfs(select);
        }else{
            if (!finished[select]) {

                count++;
                for (int i = select; i != idx; i = arr[i]) {
                    count++;
                }
            }
        }

        finished[idx] = true;
    }

}
