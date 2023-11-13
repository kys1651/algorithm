import java.util.Scanner;
import java.util.HashMap;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
 		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] lottos = new String[n];
            HashMap<String, Integer> map = new HashMap<>();
            String[] checks = new String[m];
            for(int i = 0; i < n; i++){
                lottos[i] = sc.next();
                map.put(lottos[i],sc.nextInt());
            }
            int result = 0;
			for(int i = 0; i < m; i++){
                String checkNum = sc.next();
                for(int j = 0; j < n; j++){
                    if(check(checkNum,lottos[j])){
                        result += map.get(lottos[j]);
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
    private static boolean check(String check, String lotto){
        for(int i = 0; i < 8; i++){
            if(check.charAt(i) != lotto.charAt(i) && lotto.charAt(i) != '*'){
                return false;
            }
        }
        return true;
    }
}