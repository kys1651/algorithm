import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static boolean[] check = new boolean[1000001];
    static void getPrime(){
        check[0] = check[1] = true;

        for(int i = 2; i <= Math.sqrt(check.length); i++){
            if(check[i]) continue;
            for(int j = i * i; j < check.length; j+= i){
                check[j] = true;
            }
        }
    }
    static int getCountGoldbach(int n){
        int count = 0;
        for(int i = 2; i <= n / 2 ;i++){
            if (!check[i] && !check[n - i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        getPrime();

        for(int i = 0 ; i < t ; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(getCountGoldbach(n)+"\n");
        }
        System.out.println(sb.toString());

    }
}