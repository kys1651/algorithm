import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] students = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(students);

        int answer = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            if(min < students[i]){
                min = students[i];
                answer++;
                students[i] = 0;
            }
        }
        min = 0;
        for(int s : students){
            if(s != 0 && min < s){
                min = s;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
