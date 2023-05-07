import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[] visited;
//    static int count = 0;
    static int answer = -1;
    static int a,b,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 사람의 수 n
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new boolean[n + 1];

        // 촌수를 계산해야하는 두 사람의 번호 a,b
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        // 부모 자식들간 관계의 수
        int m = Integer.parseInt(br.readLine());

        // 관계 이어주기
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = 1;
        }
        dfs(a, 0);

        System.out.println(answer);
    }

    private static void dfs(int start, int count) {
        visited[start] = true;

        if(start == b){
            answer = count;
            return;
        }


        for(int i = 1; i <= n; i++){
            if(map[start][i] == 1 && visited[i] == false){
                dfs(i,count+1);
            }
        }
    }
}