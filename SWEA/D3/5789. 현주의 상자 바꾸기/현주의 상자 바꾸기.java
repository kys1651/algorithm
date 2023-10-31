import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n+1];
            for(int i = 1; i <= q; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                for(;a <= b; a++){ arr[a] = i;}
            }
            System.out.print("#" + tc + " ");
            for(int i = 1; i <=n ;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
		}
	}
}