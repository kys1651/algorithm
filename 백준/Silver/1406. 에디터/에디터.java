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
		for(char ch : input.toCharArray()) {
			left.push(ch);
		}
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			switch (command[0]) {
			case "P":
				left.push(command[1].charAt(0));
				break;
			case "L":
				if (!left.isEmpty())
					right.push(left.pop());
				break;
			case "D":
				if (!right.isEmpty())
					left.push(right.pop());
				break;
			case "B":
				if (!left.isEmpty())
					left.pop();
				break;
			}
		}
		StringBuilder answer = new StringBuilder();
		while(!left.isEmpty()) {
			answer.append(left.pop());
		}
		answer = answer.reverse();
		while(!right.isEmpty()) {
			answer.append(right.pop());
		}
		System.out.println(answer);
		
	}
}
