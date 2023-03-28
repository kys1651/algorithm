import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static char[] c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        String str = "";
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            int count = (int) Math.pow(3, n);
            c = new char[count];

            for(int i = 0 ; i < count; i++){
                c[i] = '-';
            }

            dfs(0, count);

            for (int i = 0; i < count; i++) sb.append(c[i]);
            System.out.println(sb);
        }
    }

    static void dfs(int start, int size) {
        if(size == 1) return;

        int newSize = size/3;

        for (int i = start + newSize; i < start + ( 2 * newSize); i++){
            c[i] = ' ';
        }

        dfs(start, newSize);
        dfs(start + 2 * newSize, newSize);
    }
}