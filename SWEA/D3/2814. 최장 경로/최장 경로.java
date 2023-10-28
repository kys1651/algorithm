import java.util.Scanner;
class Solution
{
    static int[][] map;
    static boolean[] visit;
    static int result;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int m = sc.nextInt();
            map = new int[n+1][n+1];
            visit = new boolean[n+1];
            result = 0;
            for(int i = 0; i <= n; i++){
                map[i][i] = 1;
            }
            for(int i = 0; i < m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                map[a][b] = map[b][a] = 1;
            }
            for(int i = 1; i <= n; i++){
                solution(0,i,0);
            }
            System.out.println("#" + tc + " " + result);
		}
	}
    
    private static void solution(int depth, int pos, int count){
        for(int i = 1; i < map.length; i++){
            if(!visit[i] && map[pos][i] == 1){
                visit[i] = true;
                solution(depth+1,i,count+1);
                visit[i] = false;
            }
        }
        result = Math.max(result, count);
    }
}