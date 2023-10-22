import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		char[][] map;
        
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            String result = "possible";
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            map = new char[a][b];
            for(int i = 0; i < a; i++){
                String line = sc.next();
                for(int j = 0; j < b; j++){
                    map[i][j] = line.charAt(j);
                }
            }

            loop : for(int i = 0; i < a; i++){
                for(int j = 0; j < b; j++){
                    if(map[i][j] != '?'){
                        if(!solution(map,i,j)){
                            result = "impossible";
                            break loop;
                        }
                    }
                }
            }
            
            System.out.printf("#%d %s\n",tc,result);
        }
	}
    
    private static boolean solution(char[][] map, int x, int y){
        int[] dirX = {1,-1,0,0};
        int[] dirY = {0,0,-1,1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i =0; i < 4; i++){
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];
                
                // 범위보다 크거나 이미 문자가 존재할 때
                if((nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length)){
                    continue;
                }

                if(map[nextX][nextY] == map[curX][curY]){
                    return false;
                }
                
                if(map[nextX][nextY] != '?'){
                    continue;
                }

                if(map[curX][curY] == '#'){
                    map[nextX][nextY] = '.';
                }else{
                    map[nextX][nextY] = '#';
                }
                queue.offer(new int[]{nextX,nextY});
            }
        }
       	return true;
    }
}