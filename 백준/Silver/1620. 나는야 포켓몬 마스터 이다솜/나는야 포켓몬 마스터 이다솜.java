import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] idxName = new String[n + 1];
        HashMap<String, Integer> nameIdx = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            nameIdx.put(input,i);
            idxName[i] = input;
        }

        for (int i = 1; i <= m; i++) {
            String input = br.readLine();

            if (nameIdx.containsKey(input)) {
                sb.append(nameIdx.get(input));
            }else{
                sb.append(idxName[Integer.parseInt(input)]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}