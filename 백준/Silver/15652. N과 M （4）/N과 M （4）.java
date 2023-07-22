import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int [] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        answer = new int[N + 1];

        solution(0,1);
        System.out.println(sb);
    }

    private static void solution(int index,int pos) {
        if(index == M){
            for (int i = 0; i < M; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(index > 0 && answer[index - 1] > i ) continue;
            answer[index] = i;
            solution(index + 1, i + 1);
        }
    }
}


