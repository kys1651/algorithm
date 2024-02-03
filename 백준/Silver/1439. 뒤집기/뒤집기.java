import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int zero = 0;
        int one = 0;

        if (input.charAt(0) == '0') zero++;
        else one++;

        for (int i = 1; i < input.length(); i++) {
            // 값이 변경되는 순간
            if (input.charAt(i - 1) != input.charAt(i)) {
                if (input.charAt(i) == '0') zero++;
                else one++;
            }
        }

        if(zero > one){
            System.out.println(one);
        }else{
            System.out.println(zero);
        }
    }
}
