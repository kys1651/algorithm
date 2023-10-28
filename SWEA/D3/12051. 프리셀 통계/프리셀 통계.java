import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            long n = sc.nextLong();
            int pd = sc.nextInt();
            int pg = sc.nextInt();
            String result = "Broken";
            if(!((pd != 0 && pg == 0) || (pd != 100 && pg == 100))){
                while( n > 0){
                    if( (n * pd) % 100 == 0){
                        result = "Possible";
                        break;
                    }
                    n--;
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}