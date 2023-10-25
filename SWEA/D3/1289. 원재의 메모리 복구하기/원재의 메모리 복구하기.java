import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            String origin = sc.next();
            char bit = origin.charAt(0);
            int result = bit - '0';
            for(char ch : origin.toCharArray()){
                if(bit != ch){
                    result++;
                    bit = ch;
                }
            }
             System.out.println("#"+tc+" "+result);
		}
	}
}
