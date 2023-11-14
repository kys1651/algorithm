import java.util.Scanner;
import java.util.HashMap;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
	 	int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 2; i <= 9; i++){
                map.put(i,4);
            }
            map.put(10,16);
            map.put(11,4);
            int total = 52 - n;
            int sum = 0;
            for(int i = 0; i < n;i++) {
                int card = sc.nextInt();
                sum += card;
                map.put(card,map.get(card) - 1);
            }
            int lower = 0;
            int upper = 0;
            for(int i = 21 - sum; i >= 2; i--){
                lower += map.getOrDefault(i,0);
            }
            upper = total - lower;
            System.out.println("#" + tc + " " + (upper >= lower ?"STOP":"GAZUA"));
		}
	}
}