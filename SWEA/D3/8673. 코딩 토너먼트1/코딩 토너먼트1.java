import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
 		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int k = (int)Math.pow(2,sc.nextInt());
            int sum = 0;
            Queue<Integer> q = new LinkedList<>();
            for(int i =0; i < k; i++){
                q.offer(sc.nextInt());
            }
            while( k != 1){
                for(int i = 0; i < k/2; i++){
                    int a = q.poll();
                    int b = q.poll();
                    int max = Math.max(a,b);
                    int min = Math.min(a,b);
                    q.offer(max);
                    sum += max - min;
                }
                k/= 2;
            }
            System.out.println("#" + tc + " " + sum);
		}
	}
}