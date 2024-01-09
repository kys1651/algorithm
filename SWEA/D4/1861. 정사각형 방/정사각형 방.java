import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Solution {
    static class Point{
        int x;
        int y;
        int count;
        
        Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int[][] map;
    static int n,resultCount,resultNum;
    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            resultNum = 0;
            resultCount = 0;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // for문을 통해서 전부 bfs를 통해 각 값 확인
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    bfs(new Point(i,j,1));
                }
            }
            sb.append("#" + tc + " " + resultNum + " " + resultCount).append("\n");
		}
        System.out.println(sb);
	}
    
    private static void bfs(Point start){
        // 큐 선언 후 시작점을 넣어줌
        Queue<Point> rooms = new LinkedList<>();
        rooms.offer(start);
        
        while(!rooms.isEmpty()){
            Point cur = rooms.poll();
            
            // 상하좌우 확인 후 범위밖이면 continue
            for(int i = 0; i < 4; i++){
                int nX = cur.x + dirX[i];
                int nY = cur.y + dirY[i];
                
                if(nX < 0 || nX >= n || nY < 0 || nY >= n){
                    continue;
                }
                
                // 다음 방의 번호가 현재 방의 번호 +1 이라면 갈 수 있음
                if(map[nX][nY] == map[cur.x][cur.y] + 1){
                    rooms.offer(new Point(nX,nY,cur.count+1));
                }
                // 못간다면 resultCount를 최신화 할 수 있다.
                else if(resultCount <= cur.count){
                    // 시작 방
                    int startRoom = map[start.x][start.y];
                    // 같다면 방의 번호가 더 작은 것으로 최신화
                    if(resultCount == cur.count){
                        resultNum = Math.min(resultNum, startRoom);
                    }else{
                        resultNum = startRoom;
                    }
                    resultCount = cur.count;
                }
            }
        }
    }
}