import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int max =0;
        String[] arr = new String[5];

        for(int i = 0 ; i < 5; i++){
            arr[i] = br.readLine();
            if(max < arr[i].length()) max = arr[i].length();
        }
        for(int i = 0 ; i < max; i++){
            for(int j = 0 ; j < 5; j++){
                if(arr[j].length() <= i ) continue;
                sb.append(arr[j].charAt(i)+"");
            }
        }
        System.out.println(sb.toString());

    }
}