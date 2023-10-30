import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main{
    static class Jewel{
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long answer = 0;
        Jewel[] jewels = new Jewel[n];
        int bags[] = new int[k];
        for(int i = 0; i < n; i++){
            jewels[i] = new Jewel(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(jewels,(o1,o2)->{
            Jewel j1 = (Jewel) o1;
            Jewel j2 = (Jewel) o2;
            if(j1.weight == j2.weight){
                return j2.value - j1.value;
            }
            return j1.weight - j2.weight;
        });
        for(int i = 0; i < k; i++){
            bags[i] = sc.nextInt();
        }
        Arrays.sort(bags);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
        for(int i = 0,j =0; i < k; i++){
            while(j < n && jewels[j].weight <= bags[i]){
                pq.offer(jewels[j++].value);
            }
            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }

}
