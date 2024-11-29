import java.util.PriorityQueue;

class Solution {
    static class Student implements Comparable<Student>{
        int idx;
        int rank;
        boolean attendance;
        
        public Student(int idx, int rank, boolean attendance){
            this.idx = idx;
            this.rank = rank;
            this.attendance = attendance;
        }
        
        @Override
        public int compareTo(Student s1){
            if(this.attendance && s1.attendance){
                return Integer.compare(this.rank, s1.rank);
            }else if(this.attendance){
                return -1;
            }else if(s1.attendance){
                return 1;
            }
            return Integer.compare(this.rank, s1.rank);
        }
    }
    
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        for(int i = 0; i < rank.length; i++){
            pq.add(new Student(i, rank[i], attendance[i]));
        }
        int answer = pq.poll().idx * 10000;
        answer += pq.poll().idx * 100;
        answer += pq.poll().idx;
        return answer;
    }
}