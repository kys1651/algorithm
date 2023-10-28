import java.util.Scanner;
class Solution
{
    static boolean[] visit;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            String result = "No";
            for(int i = 1; i <= 9; i++){
                if(n % i == 0 && n / i < 10){
                    result = "Yes";
                    break;
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}
