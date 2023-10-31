import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean[] students = new boolean[n+1];
            for(int i = 0 ; i < k ; i++){ students[sc.nextInt()] = true;}
            System.out.print("#" + tc + " " );
            for(int i = 1; i <= n; i++) {
                if(!students[i]) System.out.print(i + " ");
            }
            System.out.println();
        }
	}
}