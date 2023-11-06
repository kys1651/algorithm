import java.util.*;
import java.util.Stack;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int k = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
            while(k --> 0){
                int n = sc.nextInt();
                if(n== 0) stack.pop();
                else stack.push(n);
            }
            int sum = 0;
            while(!stack.isEmpty()) sum += stack.pop();
            System.out.println("#" + tc + " " + sum);
		}
	}
}