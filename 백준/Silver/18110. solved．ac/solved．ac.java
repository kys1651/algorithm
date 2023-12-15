import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] peoples = new int[n];
        for(int i = 0; i < peoples.length; i++){
            peoples[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(peoples);
        int len = (int)Math.round(n * 0.15);
        int result = 0;
        for(int i = len; i < n - len; i++){
            result += peoples[i];
        }
        System.out.println((int)Math.round(result / (n - len * 2.0)));
    }
}