import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }

        String[] id = new String[N];
        for (String tmp : map.keySet()) {
            id[map.get(tmp)] = tmp;
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(id[i] == null) continue;
            sb.append(id[i]).append('\n');
            if (++count == K) {
                break;
            }
        }
        System.out.println(sb);
    }
}
