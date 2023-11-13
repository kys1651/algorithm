import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        long[] nums = new long[101];
		for(int tc = 1; tc <= T; tc++){
            int n = sc.nextInt();
            nums[1] = nums[2] = nums[3] = 1;
            for(int i = 4; i <= n; i++){
                if(nums[i] == 0){
                    nums[i] = nums[i-3] + nums[i-2];
                }
            }
            System.out.println("#" + tc + " " + nums[n]);
		}
	}
}