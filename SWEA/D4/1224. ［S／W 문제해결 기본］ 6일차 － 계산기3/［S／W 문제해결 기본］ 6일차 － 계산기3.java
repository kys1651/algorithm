import java.util.Scanner;
import java.util.Stack;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
            sc.nextInt();
            Stack<Integer> nums = new Stack<>();
            Stack<Character> oper = new Stack<>();
            String line = sc.next();
            for(char ch : line.toCharArray()){
                if(ch == '+'){
                    if(!oper.isEmpty() && oper.peek() == '+'){
                        nums.push(nums.pop() + nums.pop());
                    }else{
                        oper.push(ch);
                    }
                }else if(ch == '*' || ch =='('){
                    oper.push(ch);
                }else if(ch == ')'){
                    while(oper.peek() != '('){
                        oper.pop();
                        nums.push(nums.pop() + nums.pop());
                    }
                    oper.pop();
                    if(!oper.isEmpty() && oper.peek() == '*'){
                        nums.push(nums.pop() * nums.pop());
                        oper.pop();
                    }
                }else{
                    if(!oper.isEmpty() && oper.peek() == '*'){
                        nums.push(nums.pop() * (ch - '0'));
                        oper.pop();
                    }else{
                        nums.push(ch - '0');
                    }
                }
            }
            int result = oper.isEmpty() ? nums.pop() : nums.pop() + nums.pop();
            System.out.println("#" + tc + " "+ result);
		}
	}
}