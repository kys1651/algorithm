import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int left = 1, right = K;
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            if(count < K){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(left);
    }
}