import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean check[] = new boolean[30];

        for(int i = 0 ; i < 28 ; i++){
            int num = Integer.parseInt(br.readLine())-1;
            check[num] = true;
        }

        for(int i = 0 ; i < 30; i++){
            if(check[i]==false) bw.write((i+1) + "\n" );
        }

        bw.flush();
    }
}
