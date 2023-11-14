import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
 		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < nums.length; i++) nums[i] = sc.nextInt();
            int result = -1;
            for(int i = 0; i <nums.length; i++){
                for(int j = i + 1; j < nums.length; j++){
                    int mul = nums[i] * nums[j];
                    if(check(mul)){
                        result = Math.max(mul,result);
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
    private static boolean check(int n){
        char[] charNum = String.valueOf(n).toCharArray();
        for(int i = 1; i < charNum.length; i++){
            if(charNum[i] - charNum[i-1] != 1) return false;
        }
        return true;
    }
}