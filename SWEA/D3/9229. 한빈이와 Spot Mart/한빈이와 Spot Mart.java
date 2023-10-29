import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int result = -1;
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            for(int i = 0; i < n - 1; i ++){
                for(int j = i + 1; j < n; j++){
                    if(m >= a[i] + a[j]){
                        result = Math.max(result,a[i]+a[j]);
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}