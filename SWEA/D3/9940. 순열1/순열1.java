import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
 		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            String result = "Yes";
            for(int i = 1; i < n; i++){
                if(nums[i] - nums[i-1] != 1){
                    result = "No";
                    break;
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}