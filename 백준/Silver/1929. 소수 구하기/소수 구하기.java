import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static boolean[] check;
    static void getPrime(){
        check[0] = check[1] = true;

        for(int i = 2; i <= Math.sqrt(check.length); i++){
            if(check[i]) continue;
            for(int j = i * i; j < check.length; j+= i){
                check[j] = true;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        check = new boolean[n+1];
        getPrime();

        for(int i = m; i <= n; i++){
            if(!check[i]) System.out.println(i);
        }
    }
}