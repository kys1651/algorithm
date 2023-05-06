import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
        import java.util.ArrayDeque;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < m ; j++){
                maze[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0,0);
        System.out.println(maze[n-1][m-1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0 ; i < 4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                if(visited[nextX][nextY] || maze[nextX][nextY] == 0)
                    continue;

                q.add(new int[]{nextX, nextY});
                maze[nextX][nextY] = maze[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}