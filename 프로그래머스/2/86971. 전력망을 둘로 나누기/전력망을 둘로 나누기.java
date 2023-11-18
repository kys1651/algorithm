import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int n, int[][] wires) {
        int result = n;
        int[][] map = new int[n+1][n+1];
        for(int i = 0; i < wires.length;i++){
            int x = wires[i][0];
            int y = wires[i][1];
            map[x][y] = map[y][x] = 1;
        }
        for(int i = 0; i < wires.length; i++){
            int x = wires[i][0];
            int y = wires[i][1];
            
            // 선 끊어놓기
            map[x][y] = map[y][x] = 0;
            
            result = Math.min(result,bfs(x,n,map));
            
            // 선 다시 연결하기
            map[x][y] = map[y][x] = 1;
        }
        return result;
    }
    private static int bfs(int start,int n,int[][] map){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        boolean[] visit = new boolean[n+1];
        visit[start] = true;
        
        int count = 1; // 연결된 숫자
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            for(int i = 1; i <= n;i++){
                if(visit[i]) continue; // 방문 했으면 넘어가기
                if(map[node][i] == 1){ // 연결 됐으면 확인하기
                    visit[i] = true;
                    count++;
                    queue.offer(i);
                }
            }
        }
        return Math.abs(2 * count - n);
    }
}