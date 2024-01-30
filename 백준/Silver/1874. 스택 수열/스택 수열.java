import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] answer= new int[n];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++) {
			answer[i] = Integer.parseInt(br.readLine());
		}
		
		final String plus = "+\n";
		final String minus = "-\n";
		int idx = 0;
		for(int i = 1; i<= n; i++) {
			stack.push(i);
			sb.append(plus);
			while(!stack.isEmpty() && answer[idx] == stack.peek()){
				idx++;
				stack.pop();
				sb.append(minus);
			}
		}
		if(stack.isEmpty()) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
		
	}
}
