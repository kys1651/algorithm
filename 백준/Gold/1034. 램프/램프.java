import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] inputs = new String[N];
        // Input
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
        }// Input End

        int K = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < M; j++) {
                if (inputs[i].charAt(j) == '0') {
                    count++;
                }
            }
            if (count <= K && count % 2 == K % 2) {
                map.put(inputs[i], map.getOrDefault(inputs[i], 0) + 1);
                if (map.get(inputs[i]) > answer) {
                    answer = map.get(inputs[i]);
                }
            }
        }

        System.out.println(answer);
    }
}