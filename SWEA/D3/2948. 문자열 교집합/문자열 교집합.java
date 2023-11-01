import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int m =sc.nextInt();
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < n; i++){
                set.add(sc.next());
            }
            int result = 0;
            for(int j = 0; j < m; j++){
                if(set.contains(sc.next())) result++;
            }
            System.out.println("#" + tc + " " + result);
        }
	}
}