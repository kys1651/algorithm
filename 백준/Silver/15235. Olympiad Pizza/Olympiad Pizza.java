import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class People{
        int idx;
        int count;

        public People(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        Queue<People> peoples = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            peoples.add(new People(i,Integer.parseInt(st.nextToken())));
        }

        int time = 0;
        while(!peoples.isEmpty()){
            time++;
            peoples.peek().count--;
            if(peoples.peek().count == 0){
                answer[peoples.remove().idx] = time;
            }else{
                peoples.add(peoples.poll());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(' ');
        }
        System.out.println(sb);

    }
}
