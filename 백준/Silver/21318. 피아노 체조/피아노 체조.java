import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(prev > cur){
                num[i-1]++;
            }
            num[i] = num[i-1];
            prev = cur;
        }

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            sb.append(num[y]-num[x]).append('\n');
        }
        System.out.println(sb);
    }
}
