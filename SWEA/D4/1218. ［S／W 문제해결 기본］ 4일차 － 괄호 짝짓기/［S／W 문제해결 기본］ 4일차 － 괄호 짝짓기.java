import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		
		HashMap<Character, Character> map = new HashMap<>();
		map.put(')','(');
		map.put(']','[');
		map.put('}','{');
		map.put('>', '<');
		for(int tc = 1; tc <= T; tc++) {
			br.readLine();
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			int result = 1;
			for(char ch : input.toCharArray()) {
				if(map.containsKey(ch)) {
					if(stack.peek() == map.get(ch)) {
						stack.pop();
					}else {
						result = 0;
						break;
					}
				}
				else {
					stack.push(ch);
				}
			}
			sb.append(String.format("#%d %d\n",tc,result));
		}
		System.out.println(sb);
	}

}
