import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();;
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                int x = sc.nextInt();
                if(x == 1){
                    pq.offer(sc.nextInt());
                }else{
                    sb.append(pq.isEmpty() ? "-1" : String.valueOf(pq.poll())).append(" ");
                }
            }
            System.out.println("#" + tc + " " + sb.toString());
        }
	}
}