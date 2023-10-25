import java.util.Scanner;
import java.util.Stack;

class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            String word = sc.next();
            for(char ch : word.toCharArray()){
                if(!stack.isEmpty() && stack.peek() == ch){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
            if(stack.isEmpty()){
                count++;
            }else{
                stack.clear();
            }
        }

        System.out.println(count);
    }
}