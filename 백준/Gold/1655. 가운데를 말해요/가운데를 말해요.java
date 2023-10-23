import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 오름차순 정렬
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)->o1-o2);
        // 내림차순 정렬
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if(minHeap.size() == maxHeap.size()) {
                maxHeap.offer(num);
            }else{
                minHeap.offer(num);
            }

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                if(minHeap.peek() < maxHeap.peek()){
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
                
        }
        System.out.println(sb.toString());
	}
}