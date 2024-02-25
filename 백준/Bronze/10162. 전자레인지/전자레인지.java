import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int A = 300;
    static final int B = 60;
    static final int C = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[3];
        answer[0] = n / A;
        n %= A;
        answer[1] = n / B;
        n %= B;
        answer[2] = n / C;
        n %= C;
        
        if(n != 0){
            sb.append(-1);
        }else{
            for (int i = 0; i < 3; i++) {
                sb.append(answer[i]).append(' ');
            }
        }
        System.out.println(sb);
    }
}
