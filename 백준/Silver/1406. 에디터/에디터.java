import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		String input = br.readLine();
		for(int i = 0; i < input.length(); i++) {
			left.push(input.charAt(i));
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			if(command.equals("L")) {
				if(!left.isEmpty()) {
					right.push(left.pop());
				}
			}else if(command.equals("D")) {
				if(!right.isEmpty()) {
					left.push(right.pop());
				}
			}else if(command.equals("B")) {
				if(!left.isEmpty()) {
					left.pop();
				}
			}else {
				left.push(command.charAt(2));
			}
		}
		StringBuilder answer = new StringBuilder();
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		while(!right.isEmpty()) {
			answer.append(right.pop());
		}
		System.out.println(answer);
		
	}
}
