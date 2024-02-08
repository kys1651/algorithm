import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int value = 666;
        int count = 1;
        while(count != n){
            value++;
            if(String.valueOf(value).contains("666")){
                count++;
            }
        }
        System.out.println(value);
    }
}