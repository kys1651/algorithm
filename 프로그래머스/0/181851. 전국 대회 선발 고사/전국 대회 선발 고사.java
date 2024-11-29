import java.util.PriorityQueue;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> rank[a] - rank[b]);
        for(int i = 0; i < rank.length; i++){
            if(attendance[i]) 
                pq.add(i);
        }
        return pq.poll() * 10000 + pq.poll() * 100 + pq.poll();
    }
}