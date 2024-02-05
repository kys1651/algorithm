import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        char[] min = new char[len];
        char[] max = new char[len];

        int start = -1;

        for (int i = 0; i < len; i++) {
            char mkNum = input.charAt(i);
            // M
            if (mkNum == 'M') {
                if (start == -1) {
                    min[i] = '1';
                    max[i] = '1';
                    start = i;
                }else{
                    min[i] = '0';
                    max[i] = '0';
                }
            }
            // K
            else {
                if (start != -1) {
                    max[start] = '5';
                    max[i] = '0';
                    start = -1;
                }else{
                    max[i] = '5';
                }
                min[i] = '5';
            }
        }
        if (start != -1) {
            for (; start < len; start++) {
                max[start] = '1';
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}

