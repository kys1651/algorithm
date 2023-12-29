import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Solution {
    // 지도를 저장 할 map
    static int[][] map;
    // 방문하는데 필요한 시간이 저장 될 visit
    static int[][] visit;
    // 상하좌우
    static int[] dirX = {-1,1,0,0};
    static int[] dirY ={0,0,-1,1};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visit = new int[n][n];
            for(int i = 0; i < n; i++){
                String line = br.readLine();
                for(int j = 0; j < n; j++){
                    map[i][j] = line.charAt(j) - '0';
                    // visit 배열은 0값을 가질 수 있으므로 -1로 초기화해준다.
                    visit[i][j] = -1;
                }
            }
            bfs();
            sb.append("#" + tc + " " + visit[n-1][n-1]).append("\n");
        }
        System.out.println(sb);
    }
    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        // 시작 지점 저장 후 0 넣어줌
        queue.offer(new int[]{0, 0});
        visit[0][0] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curTime = visit[cur[0]][cur[1]];

            for(int i = 0; i < dirX.length; i++){
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                // 범위밖인 경우
                if(check(nX, nY)){
                    continue;
                }

                // 처음 방문했거나 기존 방문시간보다 작은 경로 복구 시간을 가질 경우
                if(visit[nX][nY] == -1 || (visit[nX][nY] > curTime + map[nX][nY])){
                    visit[nX][nY] = curTime + map[nX][nY];
                    queue.offer(new int[]{nX, nY});
                }
            }
        }
    }

    private static boolean check(int nX, int nY) {
        return nX < 0 || nX >= map.length || nY < 0 || nY >= map[nX].length;
    }
}