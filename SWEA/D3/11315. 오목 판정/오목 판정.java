import java.util.Scanner;
class Solution
{
    static int[] dirX ={0,1,1,1};
    static int[] dirY ={1,1,0,-1};
    static char[][] board;
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            board = new char[n][n];
            for(int i = 0; i < n; i++){
                board[i] = sc.next().toCharArray();
            }
            String result = "NO";
            loop: for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 'o'){
                        for(int d = 0; d < 4; d++){
                            if(check(i,j,d)){
                                result = "YES";
                                break loop;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
    private static boolean check(int x, int y, int d){
		int count = 0;
        int nx = x,ny = y;
        for(int idx = 0; idx < 4; idx++){
            nx += dirX[d];
            ny += dirY[d];
            // 범위 밖이면 false
            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[nx].length){
                return false;
            }
            // 돌이 없으면 false
            if(board[nx][ny] == '.'){
                return false;
            }
            count++;
        }
       	return count == 4;
    }
}