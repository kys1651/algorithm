import java.io.*;
import java.util.*;

class Main
{
    static class Problem implements Comparable{
        int deadline;
        int ramen;

        public Problem(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Object o) {
            Problem p = (Problem) o;
            if(this.deadline != p.deadline){
                return this.deadline - p.deadline;
            }
            return p.ramen - this.ramen;
        }
    }

	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Problem> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            list.add(new Problem(deadline, ramen));
        }

        Collections.sort(list);
        
        for(Problem p : list){
            int dead = p.deadline;
            int ramen = p.ramen;
            pq.offer(ramen);

            // pq의 사이즈는 여태까지 흘러간 시간 
            // 만약 데드라인이 pq.size()보다 크다면 poll
            if(dead < pq.size()){
                pq.poll();
            }
        }

        int result = 0;
        while(!pq.isEmpty()){
            result += pq.poll();
        }

        System.out.println(result);
	}
}