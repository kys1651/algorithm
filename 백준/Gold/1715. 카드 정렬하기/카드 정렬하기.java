import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int result = 0;
        for(int i = 1; i <= n; i++){
            int cards = Integer.parseInt(br.readLine());
            queue.offer(cards);
        }

        while(queue.size() > 1){
            int add = queue.poll() + queue.poll();
            result += add;
            queue.offer(add);
        }
        System.out.println(result);
	}
}