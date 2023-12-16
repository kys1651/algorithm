import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static int[] result = new int[6];
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        result = new int[6];
        while (true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            visit = new boolean[k];
            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth,int pos) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            result[depth] = nums[i];
            dfs(depth + 1, i + 1);
        }
    }
}
