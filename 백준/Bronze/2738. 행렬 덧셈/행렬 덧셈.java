import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int arr[][] = new int[N][M];
        for(int i = 0 ; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                String num[] = line.split(" ");
                arr[i][j] = Integer.parseInt(num[j]);
            }
        }

        for(int i = 0 ; i < N; i++){
            String line = br.readLine();

            for(int j = 0; j < M; j++){
                String num[] = line.split(" ");
                arr[i][j] += Integer.parseInt(num[j]);
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
