import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        char[] min = new char[len];
        char[] max = new char[len];

        // 만약 K가 없다면 max는 1로 채워지고 min은 0으로 채워져야한다.
        if(!input.contains("K")){
            Arrays.fill(min, '0');
            Arrays.fill(max, '1');
            min[0] = '1';
            System.out.println(max);
            System.out.println(min);
            return;
        }


        int start = -1;
        for (int i = 0; i < len; i++) {
            char mkNum = input.charAt(i);
            // M일 때
            if (mkNum == 'M') {
                // M을 처음 만난 경우에는 -1이다.
                if (start == -1) {
                    // 시작점은 '1'로 한다.
                    min[i] = max[i] ='1';
                    // 시작점을 기록한다.
                    start = i;
                }else{
                    min[i] = max[i] = '0';
                }
            }
            // K
            else {
                // M을 만난 적 있다면 max의 시작점에는 5를 넣어주고 현재 위치에는 0을 넣어준다.
                if (start != -1) {
                    max[start] = '5';
                    max[i] = '0';
                    // 시작점 지워준다.
                    start = -1;
                }else{
                    // M을 만난 적 없다면 '5'를 넣어주는게 큼
                    max[i] = '5';
                }
                // min에는 K를 만날 때 무조건 5를 넣어준다.
                min[i] = '5';
            }
        }
        // 만약 M으로 이어져서 끝났다면? 1로 채워준다.
        // ex) MMMM -> 1000보다 1111이 큼
        if (start != -1) {
            for (; start < len; start++) {
                max[start] = '1';
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}

