import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++)
		{
            int n = sc.nextInt();
            int[] num = new int[8];
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < 8; i++){
                q.offer(sc.nextInt());
            }
			while(!cycle(q)){}
            System.out.print("#" + tc + " ");
            while(!q.isEmpty()){
                System.out.print(q.poll() + " ");
            }
            System.out.println("0");
		}
	}
    private static boolean cycle(Queue<Integer> q){
        for(int i = 1; i <= 5; i++){
            int n = q.poll();
            if(n - i <= 0){
                return true;
            }
            q.offer(n - i);
        }
        return false;
    }
}
