import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
        {
            int n = sc.nextInt();
            System.out.println("#" + tc + " " + n / 3);
		}
	}
}