import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return solve(maps);
    }
    
    private static int solve(int[][] maps){
        int n = maps.length, m = maps[0].length;
        
        int[] dirX = {-1,1,0,0};
        int[] dirY = { 0,0,-1,1};
        maps[0][0] = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0,1});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == n - 1 && cur[1] == m - 1) {
                return cur[2];
            }
                
            for(int i = 0; i < 4; i++){
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];
                if(isIn(nX, nY, n, m) && maps[nX][nY] == 1){
                    maps[nX][nY] = 0;
                    queue.add(new int[] {nX,nY, cur[2]+1});
                }
            }
        }
        
        return -1;
    }
    private static boolean isIn(int x, int y, int n, int m){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}