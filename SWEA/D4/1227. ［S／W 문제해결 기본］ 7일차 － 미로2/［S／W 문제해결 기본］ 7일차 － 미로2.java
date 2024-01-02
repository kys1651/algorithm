import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[][] map;
    static boolean[][] visit;
    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};
    static int[] start,end;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++) {
            br.readLine();
            map = new int[100][100];
            visit = new boolean[100][100];
            for(int i = 0; i < 100; i++){
                String line = br.readLine();
                for(int j = 0; j < 100; j++){
                    map[i][j] = line.charAt(j) - '0';
                    if(map[i][j] == 2){
                        start = new int[]{i,j};
                    }else if(map[i][j] == 3){
                        end = new int[]{i,j};
                    }
                }
            }
            sb.append("#" + tc + " " + (bfs() ? "1" : "0")).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bfs(){
        Queue<int []> queue = new LinkedList<>();
        queue.offer(start);
        visit[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] ns = queue.poll();
            int x = ns[0];
            int y = ns[1];

            for(int i = 0 ; i < 4; i++){
                int nX = x + dirX[i];
                int nY = y + dirY[i];

                if(check(nX, nY) || map[nX][nY] == 1 || visit[nX][nY]){
                    continue;
                }

                if(nX == end[0] && nY == end[1]){
                    return true;
                }
                visit[nX][nY] = true;
                queue.offer(new int[] { nX, nY});
            }
        }
        return false;
    }
    private static boolean check(int x, int y){
        return x < 0 || x > 100 || y < 0 || y > 100;
    }
}