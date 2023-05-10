import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int N,M;
    static int[] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N + 1];
        visited = new boolean[N + 1];

        solution(0,1);

        System.out.println(sb.toString());
    }

    private static void solution(int index,int pos) {
        if(index==M){
            for(int i = 0 ; i < M; i++){
                sb.append(map[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = pos; i <= N; i++){
                map[index] = i;
                solution(index + 1,i+1);
        }
    }
}
