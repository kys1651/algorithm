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
        Queue<Point> rooms = new LinkedList<>();
        rooms.offer(start);
        
        while(!rooms.isEmpty()){
            Point cur = rooms.poll();
            
            for(int i = 0; i < 4; i++){
                int nX = cur.x + dirX[i];
                int nY = cur.y + dirY[i];
                
                if(nX < 0 || nX >= n || nY < 0 || nY >= n){
                    continue;
                }
                
                if(map[nX][nY] == map[cur.x][cur.y] + 1){
                    rooms.offer(new Point(nX,nY,cur.count+1));
                }else{
                    if(resultCount <= cur.count){
                        int startRoom = map[start.x][start.y];                        
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
}