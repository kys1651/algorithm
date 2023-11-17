import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Main {
    static int n;
    static int[][] map;
    static int[] dirX = {-2,-2,0,0,2,2};
    static int[] dirY = {-1,1,-2,2,-1,1};
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        
        bfs(startX,startY,endX,endY);
        System.out.println(map[endX][endY] ==  0? -1 : map[endX][endY]);
	}

    private static void bfs(int startX, int startY, int endX,int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX,startY});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < dirX.length; i++){
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];
                if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[nextX].length){
                    continue;
                }
                if(nextX == startX && nextY == startY){
                    continue;
                }
                if((map[nextX][nextY] == 0) || (map[nextX][nextY] > map[curX][curY] + 1)){
                    map[nextX][nextY] = map[curX][curY] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }
}