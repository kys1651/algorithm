import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            int count = Integer.parseInt(br.readLine());
            for (int j = 0; j < count; j++) {
                map.put(br.readLine(), name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String k = br.readLine();
            int p = Integer.parseInt(br.readLine());
            if (p == 1) {
                sb.append(map.get(k)).append('\n');
            }else{
                ArrayList<String> nameList = new ArrayList<>();
                for (String name : map.keySet()) {
                    if (map.get(name).equals(k)) {
                        nameList.add(name);
                    }
                }
                Collections.sort(nameList);
                for (String n : nameList) {
                    sb.append(n).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
