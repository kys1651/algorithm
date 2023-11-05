import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n  = sc.nextInt();
            int[] nums = new int[n];
            int avg = 0;
            int result = 0;
            for(int i = 0; i < n ;i++){  
                nums[i] = sc.nextInt();
                avg += nums[i];
            }
            avg /= n;
            for(int num : nums){
                if(avg > num){
                    result += (avg - num);
                }
            }
            System.out.println("#" + tc +" " + result);
		}
	}
}