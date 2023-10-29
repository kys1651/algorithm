import java.util.Scanner;
import java.util.Arrays;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        String[] nums = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            sc.next();
            int n = sc.nextInt();
            String[] inputs = new String[n];
            for(int i = 0; i < n; i++){
                inputs[i] = sc.next();
            }
            Arrays.sort(inputs,(o1, o2) -> {
                int idx1 = 0;
                int idx2 = 0;
                for(int i = 0; i < nums.length; i++){
                    if(nums[i].equals(o1)) idx1 = i;
                    if(nums[i].equals(o2)) idx2 = i;
                }
                return idx1 - idx2;
            });
            StringBuilder sb = new StringBuilder();
            for(String str : inputs){
                sb.append(str).append(" ");
            }
            System.out.println("#" + tc + " " + sb.toString());
        }
	}
}