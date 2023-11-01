import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = 0;
            for(int i = 0; i < 3; i++){
                n ^= sc.nextInt();
            }
            System.out.println("#" + tc + " " + n);
		}
	}
}