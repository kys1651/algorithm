import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
 		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            Queue<String> queue1 = new LinkedList<>();
            Queue<String> queue2 = new LinkedList<>();
            for(int i = 0; i < (n/2 + n % 2); i++){
                queue1.add(sc.next());
            }
            for(int i = 0; i < n/2; i++){
                queue2.add(sc.next());
            }
            StringBuilder sb = new StringBuilder();
            while(!queue2.isEmpty()){
                sb.append(queue1.poll()+ " " );
                sb.append(queue2.poll() + " ");
            }
            if(!queue1.isEmpty()) sb.append(queue1.poll());
            System.out.println("#" + tc + " " + sb.toString());
        }
	}
}