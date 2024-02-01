import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] prime;
    static int[] firstUnitPrime = {2,3,5,7};
    static int[] secondUnitPrime = {1,3,7,9};
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new int[N];
        getPrime(N+1);

        for(int i = 0 ; i < firstUnitPrime.length; i++) {
            combination(1,firstUnitPrime[i]);
        }


        System.out.println(sb);
    }

    private static void combination(int depth,int value) {
        if(depth == N) {
            sb.append(value).append("\n");
            return;
        }

        for(int i = 0; i < secondUnitPrime.length; i++) {
            int nextValue = value * 10 + secondUnitPrime[i];
            if(!isValid(nextValue)) continue;
            combination(depth+1, nextValue);
        }
    }

    private static boolean isValid(int value) {
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if(!prime[i] && value % i == 0){
                return false;
            }
        }
        return true;
    }


    private static void getPrime(int size) {
        // true : 소수아님, false: 소수
        size = (size / 2) + (size % 2);
        prime = new boolean[(int)Math.pow(10,size)];
        prime[0] = prime[1] = true;
        for(int i = 2; i < Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;

            for(int j = i * 2; j < prime.length; j+= i) {
                prime[j] = true;
            }
        }
    }
}
