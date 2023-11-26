import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[Integer.parseInt(st.nextToken())];
            for(int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long result = 0;
            for(int i = 0; i < arr.length-1; i++){
                for(int j = i + 1; j < arr.length; j++){
                    result += GCD(arr[i], arr[j]);
                }
            }
            System.out.println(result);
        }

    }

    private static int GCD(int a, int b) {
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
