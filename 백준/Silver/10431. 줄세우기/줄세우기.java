import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++){
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int[] students = new int[20];
            for(int i = 0; i < 20; i++){
                students[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1; i< 20; i++){
                for(int j = i -1; j >= 0; j--){
                    if(students[i] < students[j]){
                        count++;
                    }
                }
            }
            sb.append(tc + " ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}