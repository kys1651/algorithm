import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] arr;
    static  int[] result = new int[6];
    static boolean[] visited;
    static int K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            if((K = Integer.parseInt(st.nextToken()))==0)
                break;

            arr = new int[K];
            visited = new boolean[K];

            for(int i = 0; i < K; i++){
                int n = Integer.parseInt(st.nextToken());
                arr[i] = n;
            }

            solution(0,0);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void solution(int depth,int pos) {
        if(depth == 6){
            for(int i = 0 ; i < 6; i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = pos; i < K; i++) {
            if(!visited[i]){
                result[depth] = arr[i];
                visited[i] = true;
                solution(depth+1,i+1);
                visited[i] = false;
            }
        }
    }


}
