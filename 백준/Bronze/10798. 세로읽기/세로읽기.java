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
        char[][] arr = new char[5][15];

        for(int i = 0 ; i < 5; i++){
            String str = br.readLine();

            if(max < str.length()) max = str.length();
            for(int j = 0; j < str.length(); j++){
                arr[i][j] = str.charAt(j);
            }
        }
        for(int i = 0 ; i < max; i++){
            for(int j = 0 ; j < 5; j++){
                if(arr[j][i] == '\0') continue;
                sb.append(arr[j][i]);
            }
        }

        System.out.println(sb.toString());

    }
}