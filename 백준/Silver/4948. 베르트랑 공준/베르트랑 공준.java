import java.io.*;

class Main {
    public static boolean[] prime = new boolean[246913];
    public static int[] count_arr = new int[246913];
    public static void get_prime(){
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++){
            if(prime[i]) continue;
            for(int j = i*i; j < prime.length; j += i){
                prime[j] = true;
            }
        }
    }
    public static void get_count(){
        int count = 0;
        for(int i = 2; i < prime.length; i++){
            if(!prime[i]) count++;

            count_arr[i] = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        get_prime();
        get_count();

        while(true){
            int n = Integer.parseInt(br.readLine());

            if( n == 0 ) break;


            bw.write(Integer.toString(count_arr[2*n]-count_arr[n])+"\n");
        }

        bw.flush();
        bw.close();
    }
}

