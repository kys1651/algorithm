import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
        import java.util.StringTokenizer;
        import java.util.ArrayDeque;

public class Main {
    static int N,M;
    static boolean[] check;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1];
        answer = new int[N + 1];
        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int index) {
        //인덱스가 마지막 개수를 채울시 출력
        if(index == M){
            for(int i = 0 ; i < M ;i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1 ~ N개의 수를 출력
        for (int i = 1; i <= N; i++) {
            if(check[i]) continue; // 이미 온 적 있으면 다음으로
            check[i] = true;
            answer[index] = i;
            dfs(index+1); // 1증가 시키고 재귀함
            check[i] = false; // 여기서 나올 모든 경우를 넣었기에 i를 사용하지 않음으로 교체
        }

    }
}