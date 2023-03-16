import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();

        int start = 0;
        int end = str.length()-1;
        boolean check = true;
        while(start < end){
            if(str.charAt(start++)!=str.charAt(end--)){
                check = false;
            }
        }
        System.out.println(check ? "1" : "0");
    }
}