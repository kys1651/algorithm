import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            String line = sc.next();
            System.out.println("#" + tc + " " + (line.length() - line.replaceAll("x","").length() < 8 ? "YES" : "NO"));
		}
	}
}