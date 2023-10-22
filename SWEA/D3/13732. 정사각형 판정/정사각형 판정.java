import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		char[][] map;
        int[] min,max;
        
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
            map = new char[N][N];
            min = null;
            max = null;
            
            String result = "yes";
            for(int i =0;i < N; i++){
                String line = sc.next();
                for(int j = 0; j < N; j++){
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == '#'){
                        if(min == null){
                            min = new int[]{i,j};
                        }
                        max = new int[] {i,j};
                    }
                }
            }
			if(min == null || !check(map,min,max) || !(max[0] - min[0] == max[1] - min[1])){
                result = "no";
            }
            System.out.println("#" + tc + " " + result);
		}
	}
    private static boolean check(char[][] map, int[] min, int[] max){
        for(int i = min[0]; i <= max[0]; i++){
            for(int j = min[1]; j <= max[1]; j++){
                    if(map[i][j] != '#'){
                        return false;
                    }
            }
        }
        return true;
    }
}