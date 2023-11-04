import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            String str = sc.next();
            int[] nums = new int[26];
            for(char ch : str.toCharArray()){
                nums[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                if(nums[i] % 2 != 0){
                    sb.append(String.valueOf((char)('a' + i)));
                }
            }
            System.out.println("#" + tc + " " + (sb.toString().isEmpty() ? "Good" : sb.toString()));
        }
	}
}