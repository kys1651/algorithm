import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
        import java.util.ArrayDeque;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] node;
    static boolean[] checked;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        node = new int[N+1][N+1];
        checked = new boolean[N+1];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            node[x][y] = node[y][x] = 1;
        }
        dfs(V);

        checked = new boolean[N+1];
        System.out.println();

        bfs(V);
    }

    private static void dfs(int i) {
        checked[i] = true;
        System.out.print(i + " ");

        for(int j = 1; j <= N; j++){
            if(node[i][j] == 1 && checked[j] == false){
                dfs(j);
            }
        }
    }

    private static void bfs(int i){
        q.offer(i);
        checked[i] = true;

        System.out.print(i + " ");
        while (!q.isEmpty()) {
            int tmp = q.poll();

            for(int j = 1; j <= N; j++){
                if(node[tmp][j] == 1 && checked[j]== false){
                    q.offer(j);
                    checked[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}