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
            String result = "impossible";
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            map = new char[a][b];
            for(int i = 0; i < a; i++){
                String line = sc.next();
                for(int j = 0; j < b; j++){
                    map[i][j] = line.charAt(j);
                }
            }
			if(check(map,'#','.') || check(map,'.','#')) {
                result = "possible";
            }
            
            System.out.printf("#%d %s\n",tc,result);
        }
	}
    
	private static boolean check(char[][] map,char a,char b){
        for(int i =0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if((i + j) % 2 == 0 && map[i][j] == a){
                    return false;
                }else if((i + j) % 2 == 1 && map[i][j] == b){
                    return false;
                }
            }
        }
        return true;
    }
}
