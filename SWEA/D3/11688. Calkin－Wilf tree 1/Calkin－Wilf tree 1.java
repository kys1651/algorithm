import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            String commands = sc.next();
            int a = 1, b = 1;
            for(char command : commands.toCharArray()){
                if(command == 'L'){
                    b = a + b;
                }else{
                    a = a + b;
                }
            }
            System.out.println("#" + tc + " " + a + " " + b);
		}
	}
}