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
            int m = sc.nextInt();
            int k = sc.nextInt();
            int [] customers = new int[n];
            for(int i = 0; i <n ; i++){
                customers[i] = sc.nextInt();
            }
            Arrays.sort(customers);
            String result = "Possible";
			for(int i = 0; i < customers.length; i++){
                if((customers[i] / m * k) - i < 1){
                    result = "Impossible";
                    break;
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}