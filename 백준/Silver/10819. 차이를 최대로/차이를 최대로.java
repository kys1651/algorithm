import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result, n;
    static int[] arr, select;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        select = new int[n];
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        brute(0);
        System.out.println(result);
    }

    private static void brute(int count) {
        if (count == n) {
            cal();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                select[count] = arr[i];
                brute(count + 1);
                visit[i] = false;
            }
        }
    }

    private static void cal() {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(select[i] - select[i + 1]);
        }
        result = Math.max(result, sum);
    }
}