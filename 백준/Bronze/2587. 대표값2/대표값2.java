import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[5];
        int avg = 0;
        for(int i = 0 ; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            arr[i] = a;
            avg += arr[i];
        }
        Arrays.sort(arr);
        System.out.println(avg/5);
        System.out.println(arr[2]);

    }
}