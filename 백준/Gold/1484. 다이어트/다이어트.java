import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int s = 1; // 기억
        int e = 2; // 현재

        ArrayList<Integer> answer = new ArrayList<>();
        while (e <= G) {
            // 현재^2 - 기억^2 = G
            // (현재 + 기억)(현재 - 기억) = G
            int result = (e + s) * (e - s);
            if(result == G){
                answer.add(e);
            }

            if(result > G){
                s++;
            }else{
                e++;
            }
        }

        if(answer.isEmpty()){
            System.out.println(-1);
        }else{
            StringBuilder sb = new StringBuilder();
            for (int n : answer) {
                sb.append(n).append('\n');
            }
            System.out.println(sb);
        }

    }
}