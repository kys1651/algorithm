import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int max = 0;
            int[] nums = new int[n + m + 1];
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++) nums[i+j]++;
            }

            for(int i = 1; i < nums.length; i++){
                if(nums[max] < nums[i]) max = i;
            }
            for(int i = 1; i < nums.length; i++){
                if(nums[max] == nums[i]) list.add(i);
            }
            Collections.sort(list);
            System.out.print("#" + tc + " ");
            for(int number : list){System.out.print(number + " ");}
            System.out.println();
		}
	}
}