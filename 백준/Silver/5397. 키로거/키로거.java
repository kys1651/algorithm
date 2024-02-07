import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			
			for (char ch : input.toCharArray()) {
				if (ch == '<') {
					if (!left.isEmpty())
						right.push(left.pop());
				} else if (ch == '>') {
					if(!right.isEmpty()) {
						left.push(right.pop());
					}
				}else if(ch == '-') {
					if(!left.isEmpty()) {
						left.pop();
					}
				}else {
					left.push(ch);
				}
			}
			
			while(!left.isEmpty()) {
				right.push(left.pop());
			}
			while(!right.isEmpty()) {
				sb.append(right.pop());
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
