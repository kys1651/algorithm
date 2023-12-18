import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime = new boolean[2000001];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        getPrime();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long sum = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
            if(sum < 4){
                sb.append("NO");
            }else if(sum % 2 == 0){
                sb.append("YES");
            }else{
                if(checkPrime(sum-2)){
                    sb.append("YES");
                }else{
                    sb.append("NO");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void getPrime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i < prime.length; i++) {
            if(prime[i]) continue;

            list.add(i);
            for (int j = 2 * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

    private static boolean checkPrime(long sum) {
        if(sum <= prime.length) return !prime[(int)sum];

        for(int i = 0; i < list.size(); i++){
            if(sum % list.get(i) == 0){
                return false;
            }
        }
        return true;
    }
}