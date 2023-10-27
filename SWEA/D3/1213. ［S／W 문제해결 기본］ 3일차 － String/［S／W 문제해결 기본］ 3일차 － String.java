import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++)
		{
            sc.nextInt();
            String keyword = sc.next();
            String str = sc.next();
            int len = str.length() - str.replaceAll(keyword,"").length();
            len /= keyword.length();
            System.out.println("#" + tc + " " + len);
		}
	}
}