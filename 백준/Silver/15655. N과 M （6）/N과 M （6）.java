import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int [] answer;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        answer = new int[M];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solution(0,0);
        
        System.out.println(sb);
    }

    private static void solution(int index, int pos) {
        if(index == M){
            for (int val : answer) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = pos; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            answer[index] = arr[i];
            solution(index + 1, i);
            visited[i] = false;
        }
    }
}


