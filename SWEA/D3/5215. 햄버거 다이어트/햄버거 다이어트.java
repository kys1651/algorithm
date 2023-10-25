import java.util.*;

class Solution
{
    static int result = 0;
    static int[][] ingredients;
    static boolean[] visit;
    static int n,l;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            result = -1;
            n = sc.nextInt();
            l = sc.nextInt();
            ingredients = new int[n][2];           
            visit = new boolean[n];
            for(int i = 0; i < n; i++){
                ingredients[i][0] = sc.nextInt();
                ingredients[i][1] = sc.nextInt();
            }
			combination(0,0,0);
            
            System.out.println("#" + tc + " " + result);
		}
	}
    private static void combination(int depth,int curCal, int score){
        for(int i = depth; i < ingredients.length; i++){
            if(curCal + ingredients[i][1] <= l){
                combination(i+1,curCal + ingredients[i][1], score + ingredients[i][0]);
            }
        }
        result = Math.max(result, score);
    }
}