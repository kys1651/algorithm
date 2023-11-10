import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++){
                sb.append(sc.next());
            }
            int idx = 0;
            while(true){
                if(!sb.toString().contains(String.valueOf(idx))){
                    System.out.println("#" + tc + " " + idx);
                    break;
                }
                idx++;
            }
		}
	}
}