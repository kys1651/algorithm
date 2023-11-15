import java.util.Scanner;
import java.util.Stack;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
            sc.nextInt();
            Stack<Integer> nums = new Stack<>();
            Stack<Character> op = new Stack<>();
            String line = sc.next();
            int result = 0;
            for(char ch : line.toCharArray()){
                if(ch == '+' || ch == '*'){
                    if(ch == '+' && !op.isEmpty() && op.peek() == '+'){
                        nums.push(nums.pop() + nums.pop());
                    }else{
                        op.push(ch);
                    }
                }else{
                    int num = ch - '0';
                    if(!op.isEmpty() && op.peek() == '*'){
                        nums.push(nums.pop() * num);
                        op.pop();
                    }else{
                        nums.push(num);
                    }
                }
            }
            result = nums.pop();
            if(!op.isEmpty()){result += nums.pop();}
            System.out.println("#" + tc + " " + result);
        }
	}
}