import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dirx = {0, 0, -1, 1};
    static int[] diry = {-1, 1, 0, 0};
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int max = 0;
        int answer = 0;
        map = new int[N][N];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max < map[i][j])
                    max = map[i][j];
            }
        }

        for(int height = 0 ; height < max; height++){
            visited = new boolean[N][N];
            int count = 0;
            
            for (int i = 0; i < N; i++) {
                for(int j = 0 ; j < N; j++){
                    if(!visited[i][j] && map[i][j] > height){
                        count++;
                        dfs(i, j,height);
                    }
                }
            }
            answer = Math.max(answer,count);
        }

        System.out.println(answer);
    }

    private static void dfs(int i, int j, int height) {
        visited[i][j] = true;
        for(int pos = 0 ; pos < 4; pos++){
            int posx = i + dirx[pos];
            int posy = j + diry[pos];

            if(posx < 0 || posy < 0 || posx > N-1 || posy > N-1) continue;
            if(visited[posx][posy]) continue;

            if(map[posx][posy] > height){
                dfs(posx, posy, height);
            }
        }
    }
}


