import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
        {
            System.out.println("#" + tc + " " + sc.next().replaceAll("[a,e,i,o,u]",""));
		}
	}
}