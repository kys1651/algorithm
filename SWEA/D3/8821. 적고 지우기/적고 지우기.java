import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int[] nums = new int[10];
            String str = sc.next();
            for(char ch : str.toCharArray()){
                int idx = ch - '0';
                nums[idx] = nums[idx] == 1 ? 0 : 1;
            }
            int result = 0;
            for(int n : nums){
                result += n;
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}