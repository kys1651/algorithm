import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] arr;
    static int N,S;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(0,0);
        if(S == 0) count--;
        System.out.println(count);
    }

    private static void solution(int depth,int sum) {
        if(depth == N){
            if(sum == S) count++;
            return;
        }

        solution(depth+1,sum + arr[depth]);
        solution(depth+1,sum);
    }
}
