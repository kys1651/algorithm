import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            String input = br.readLine();
            st = new StringTokenizer(input);
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if(arr[j] < L) {
                    sum = -1;
                    break;
                }
                sum += arr[j];
            }
            if (sum >= K) {
                count++;
                sb.append(input).append(' ');
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
