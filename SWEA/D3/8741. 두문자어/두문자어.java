import java.io.*;
class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            for(String s : str.split(" ")){sb.append(s.charAt(0));}
            System.out.println("#" + tc + " "+ sb.toString().toUpperCase());
		}
	}
}