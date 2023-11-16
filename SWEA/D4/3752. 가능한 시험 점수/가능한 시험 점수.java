import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
class Solution {
    static HashSet<Integer> result;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            result = new HashSet<>();
            result.add(0);
            for(int i = 0; i < n; i++){
                addScore(nums[i]);
            }
            
            System.out.println("#" + tc + " " + result.size());
		}
	}
    private static void addScore(int score) {
        HashSet<Integer> set = new HashSet<>();
        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()){
            set.add(iterator.next() + score);
        }
        result.addAll(set);
    }
}