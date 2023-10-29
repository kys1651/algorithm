import java.util.Scanner;
import java.util.HashSet;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            while(n!=0){
                set.add(n%10);
                n /= 10;
            }
            System.out.println("#" + tc + " " + set.size());
        }
	}
}