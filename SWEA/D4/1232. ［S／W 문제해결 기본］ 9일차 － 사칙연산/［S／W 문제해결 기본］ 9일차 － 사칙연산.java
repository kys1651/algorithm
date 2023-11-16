import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            int[] nums = new int[n+1];
            int[][] next = new int[n+1][2];
            char[] oper = new char[n+1];
            
            for(int i = 1; i <= n; i++){
                int idx = sc.nextInt();
                String tmp = sc.next();
                if(tmp.equals("+") || tmp.equals("-") || tmp.equals("/") || tmp.equals("*")){
                    oper[idx] = tmp.charAt(0);
                    nums[idx] = 0;
                    next[idx][0] = sc.nextInt();
                    next[idx][1] = sc.nextInt();
                }else{
                    nums[idx] = Integer.valueOf(tmp);
                    oper[idx] = ' ';
                }
            }
            int result = recursion(1,nums,next,oper);
            System.out.println("#" + tc + " " + result);
		}
	}
    private static int recursion(int pos, int[] nums, int[][] next,char[] oper){
        switch (oper[pos]){
            case '+':
                return recursion(next[pos][0],nums,next,oper) + recursion(next[pos][1] , nums,next, oper);
            case '-':
                return recursion(next[pos][0],nums,next,oper) - recursion(next[pos][1] , nums,next, oper);
            case '/':
                return recursion(next[pos][0],nums,next,oper) / recursion(next[pos][1] , nums,next, oper);
            case '*':
                return recursion(next[pos][0],nums,next,oper) * recursion(next[pos][1] , nums,next, oper);
            default:
                return nums[pos];
        }
    }
}