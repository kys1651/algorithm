import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Exam {
        int score;
        int time;

        public Exam(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Exam> stack = new Stack<>();
        Exam e = null;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            if(idx == 0){
                if(e != null){
                    e.time--;
                    if (e.time == 0) {
                        answer += e.score;
                        e = null;
                    }
                }
                else if(!stack.isEmpty()){
                    e = stack.pop();
                    e.time--;
                    if(e.time == 0){
                        answer += e.score;
                        e = null;
                    }
                }
                continue;
            }
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken()) - 1;
            if(time == 0){
                answer += score;
                continue;
            }
            if(e != null){
                stack.push(e);
            }
            e = new Exam(score, time);
        }
        System.out.println(answer);
    }
}
