import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '.') continue;

                boolean u = i - 1 < 0 ? false : "|+14MZ".contains(map[i - 1][j] + "");
                boolean d = i + 1 >= R ? false : "|+23MZ".contains(map[i + 1][j] + "");
                boolean l = j - 1 < 0 ? false : "-+12MZ".contains(map[i][j - 1] + "");
                boolean r = j + 1 >= C ? false : "-+34MZ".contains(map[i][j + 1] + "");

                char block = 0;
                if (u && d && l && r) {
                    if ("MZ".contains(map[i - 1][j] + "") && "MZ".contains(map[i + 1][j] + "")) {
                        block = '-';
                    } else if ("MZ".contains(map[i][j - 1] + "") && "MZ".contains(map[i][j + 1] + "")) {
                        block = '|';
                    } else if ("MZ".contains(map[i][j - 1] + "") && "MZ".contains(map[i - 1][j] + "")) {
                        block = '1';
                    } else if("MZ".contains(map[i][j-1] +"") && "MZ".contains(map[i+1][j]+"")){
                        block = '2';
                    } else if("MZ".contains(map[i][j+1]+"") && "MZ".contains(map[i+1][j]+"")){
                        block = '3';
                    } else if("MZ".contains(map[i][j+1] + "") && "MZ".contains(map[i-1][j]+"")){
                        block = '4';
                    }else{
                        block = '+';
                    }
                }
                else if(u && d) block = '|';
                else if(l && r) block = '-';
                else if(d && r) block = '1';
                else if(u && r) block = '2';
                else if(l && u) block = '3';
                else if(l && d) block = '4';

                if(block == 0){
                    continue;
                }
                System.out.println(i + 1 + " " + (j + 1) + " " + block);
                System.exit(0);
            }
        }
    }
}
