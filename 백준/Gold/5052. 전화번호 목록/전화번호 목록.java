import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final String YES = "YES", NO = "NO";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String[] arr = new String[N];
            for(int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);
            sb.append(solve(arr)).append('\n');
        }
        System.out.println(sb);
    }

    private static String solve(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].startsWith(arr[i-1])) {
                return NO;
            }
        }
        return YES;
    }
}
