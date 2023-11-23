import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n =Integer.parseInt(br.readLine());
        int len = 2 * n;
        for(int i=1,j= 1; i < len; i++){
            sb.append("*".repeat(j));
            sb.append(" ".repeat((n-j)*2));    
            sb.append("*".repeat(j));
            sb.append("\n");
            if(i < len/2){
                j++;
            }else{ 
                j--;
            }
        }
        System.out.println(sb.toString());
    }
}