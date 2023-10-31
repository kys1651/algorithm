import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc= 1; tc <= T; tc++)
		{
	        String a = sc.next().replaceAll("[CEFGHIJKLMNSTUVWXYZ]","C").replaceAll("[ADOPQR]","A");
            String b = sc.next().replaceAll("[CEFGHIJKLMNSTUVWXYZ]","C").replaceAll("[ADOPQR]","A");
            System.out.println("#" + tc + " " + (a.equals(b)?"SAME":"DIFF"));
        }
	}
}