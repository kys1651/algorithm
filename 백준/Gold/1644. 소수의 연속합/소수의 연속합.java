import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        Prime(n);

        int answer = solution(n);
        System.out.println(answer);
    }

    private static int solution(int result) {
        int answer = 0;

        for (int i = 2; i < arr.length; i++) {
            if(arr[i] == 0) continue;
            int sum = arr[i];
            if(sum == result) return answer+1;


            for(int j = i+1; j < arr.length; j++){
                if(sum == result){
                    answer ++;
                    break;
                }else if(sum > result){
                    break;
                }
                sum += arr[j];

            }
        }
        
        return answer;
    }

    private static void Prime(int n) {
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if(arr[i] == 0) continue;

            for (int j = 2 * i; j <= n; j += i) {
                arr[j] = 0;
            }
        }
    }

}
