import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
        {
            int l = sc.nextInt();
            int h = sc.nextInt();
            int x = sc.nextInt();
            
            int range = h - l;
            int n = l - x;
            if(n < 0){
                n = (range + n > 0 ? 0 : -1);
            }
			System.out.printf("#%d %d\n",tc,n);
		}
	}
}