import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++){
            queue.clear();
            long result = 0;

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());    
            for(int i = 1; i<= n; i++){
                long cards = Long.parseLong(st.nextToken());
                queue.offer(cards);
            }

            while(queue.size() > 1){
                long add = queue.poll() + queue.poll();
                result += add;
                queue.offer(add);
            }
            sb.append(result).append("\n");
        }
        
        System.out.println(sb.toString());
        
	}
}