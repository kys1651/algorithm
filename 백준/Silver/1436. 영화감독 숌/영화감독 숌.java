import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(br.readLine());
        int i = 0, count =0;
        while(count != N){
            i++;
            String tmp = String.valueOf(i);
            if(tmp.indexOf("666")!=-1) count ++;
        }
        System.out.println(i);
    }
}