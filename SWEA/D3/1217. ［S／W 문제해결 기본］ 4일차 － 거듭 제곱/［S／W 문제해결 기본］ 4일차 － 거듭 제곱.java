import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++)
		{
            System.out.println("#" + sc.nextInt() + " " +(int)Math.pow(sc.nextInt(),sc.nextInt()));
		}
	}
}