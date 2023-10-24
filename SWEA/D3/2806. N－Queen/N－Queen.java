import java.util.Scanner;

class Solution
{
    static int[] arr;
    static int n,result;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            n = sc.nextInt();
            arr = new int[n];
            result = 0;
            
            nQueen(0);
            
            System.out.println("#" + tc + " " + result);
		}
	}
    
    private static void nQueen(int depth){
        if(depth == n){
            result++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            arr[depth] = i;
            
            if(isPossible(depth)){
                nQueen(depth+1);
            }
        }
    }
    
    private static boolean isPossible(int col){
        for(int i = 0; i < col; i++){
            if(arr[col] == arr[i]){
                return false;
            }
            
            if(Math.abs(i - col) == Math.abs(arr[i] - arr[col])){
                return false;
            }
        }
        return true;
    }
}