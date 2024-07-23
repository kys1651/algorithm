import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] next = new int[N + 1];
        int[] tail = new int[N + 1];

        // Input
        String[] univ = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            univ[i] = br.readLine();
            tail[i] = i;
        }// Input End

        int curIdx = 0;
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            next[tail[to]] = from;
            tail[to] = tail[from];
            curIdx = to;
        }

        StringBuilder sb = new StringBuilder();
        while(curIdx != 0){
            sb.append(univ[curIdx]);
            curIdx = next[curIdx];
        }
        System.out.println(sb);
    }
}