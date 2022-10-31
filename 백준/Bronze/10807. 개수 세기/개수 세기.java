import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int num[] = new int[n];
        int v = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0 ; i < n; i++){
            if(v == Integer.parseInt(line[i])) result++;
        }
        bw.write(result+"");
        bw.flush();
    }
}
