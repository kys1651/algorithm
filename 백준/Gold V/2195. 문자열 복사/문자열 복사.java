import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		int s = 0, e = 1;
		int answer = 0;
		while (e != P.length() + 1) {
			while (e <= P.length() && S.indexOf(P.substring(s, e)) != -1) {
				e++;
			}
			s = e - 1;
			answer++;
		}
		System.out.println(answer);
	}
}
