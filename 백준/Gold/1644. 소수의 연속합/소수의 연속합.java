import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean[] prime;
    static ArrayList<Integer> primeNumber = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        getPrime(n);
        int count = 0;
        for(int i = 0; i < primeNumber.size(); i++){
            // 시작하는 숫자가 절반보다 크다면 종료
            int sum = primeNumber.get(i);
            if(sum > n / 2) break;
            for(int j = i + 1; j < primeNumber.size(); j++){
                sum += primeNumber.get(j);
                if(sum == n) count ++;
                else if(sum > n){
                    break;
                }
            }
        }
        // n이 소수인지 확인 -> 하나만으로 구성이 가능하기 때문에
        if(!prime[n]) count++;
        System.out.println(count);
    }

    private static void getPrime(int n) {
        prime = new boolean[n + 1];
        prime[0] = prime[1] = true;
        for(int i = 2 ; i <= Math.sqrt(n); i++){
            if(prime[i]) continue;
            for(int j = 2 * i; j <= n; j+= i){
                prime[j] = true;
            }
        }
        for(int i = 2; i <= n; i++){
            if(!prime[i]){
                primeNumber.add(i);
            }
        }
    }
}
