import java.util.Scanner;
import java.util.Stack;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
            sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            String line = sc.next();
            stack.push(line.charAt(0) - '0');
            for(int i = 1; i < line.length(); i++){
                if(line.charAt(i) != '+'){
                    stack.push(stack.pop() + line.charAt(i) - '0');                   
                }
            }
            System.out.println("#" + tc + " " + stack.pop());
		}
	}
}