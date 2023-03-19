import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] a = new int[3];
        int[] b = new int[3];
        int x,y;
        for(int i = 0 ; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        if(a[0] == a[1]){
            x = a[2];
        }else if(a[0] == a[2]){
            x = a[1];
        }else{
            x = a[0];
        }

        if(b[0] == b[1]) y = b[2];
        else if(b[0] == b[2]) y = b[1];
        else y = b[0];

        System.out.println(x + " " + y);
    }
}