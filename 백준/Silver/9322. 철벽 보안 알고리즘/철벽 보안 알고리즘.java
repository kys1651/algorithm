import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                map.put(st.nextToken(), i);
            }

            st = new StringTokenizer(br.readLine());
            int[] indexArr = new int[n];
            for (int i = 0; i < n; i++) {
                indexArr[i] = map.get(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            String[] answer = new String[n];
            for (int i = 0; i < n; i++) {
                answer[indexArr[i]] = st.nextToken();
            }

            for(String s : answer){
                sb.append(s).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}