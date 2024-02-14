import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String keyword = br.readLine();
		int answer = 0;
		while(text.indexOf(keyword)!=-1) {
			text = text.replaceFirst(keyword, "|");
			answer++;
		}
		System.out.println(answer);
	}
}
