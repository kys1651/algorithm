import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
            int lower = sc.nextInt();
            int upper = sc.nextInt();
            int result = 0;
            for(; lower<= upper; lower++){
                if(lower % Math.sqrt(lower) == 0){
                    if(palindrome(lower)&&palindrome((int)Math.sqrt(lower)))
                        result++;
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
    private static boolean palindrome(int num){
        String strNum = String.valueOf(num);
        for(int i = 0; i < strNum.length()/2 ; i++){
            if(strNum.charAt(i) != strNum.charAt(strNum.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
    
}