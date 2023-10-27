import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
            int len = sc.nextInt();
            char[] origin = sc.next().toCharArray();
            char[] check = sc.next().toCharArray();
            int result = 0;
            for(int i = 0; i < len; i++){
                if(origin[i] == check[i]) result++;
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}