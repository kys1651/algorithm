import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static LinkedList<Integer> list = new LinkedList<>();
    static int[] posx = {-1, 1, 0, 0};
    static int[] posy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        // map 입력 받기
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0 ; j < n; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }


        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }


        Collections.sort(list);
        System.out.println(list.size());
        for (int num : list) {
            System.out.println(num);
        }

    }

    private static void bfs(int i, int j) {
        int local_count = 1;
        q.offer(new int[] {i,j});
        visited[i][j] = true;


        while (!q.isEmpty()) {
            int num[] = q.poll();
            int nx = num[0];
            int ny = num[1];

            for(int now = 0 ; now < 4; now++){
                int newx = nx + posx[now];
                int newy = ny + posy[now];

                if(newx>=0 && newy >= 0 && newx < n && newy < n){
                    if(map[newx][newy] == 1 && !visited[newx][newy]){
                        q.add(new int[]{newx, newy});
                        visited[newx][newy] = true;
                        local_count++;
                    }
                }
            }
        }
        list.add(local_count);
    }
}