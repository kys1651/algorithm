import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            for(String str : line.split(" ")){
                StringBuilder tmp = new StringBuilder(str);
                sb.append(tmp.reverse()).append(" ");
            }
            arr[i] = sb.toString();
        }
        
        for(String str : arr){
            System.out.println(str);
        }
    }
}