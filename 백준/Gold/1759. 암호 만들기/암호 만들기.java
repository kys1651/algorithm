import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] list;
    static char[] code;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            list[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);
        
        tracking(0,0);

    }

    private static void tracking(int idx,int depth) {
        if(depth == L){
            if(check()){
                System.out.println(code);
            }
            return;
        }

        for(int i = idx; i < C; i++){
            code[depth] = list[i];
            tracking(i + 1, depth + 1);
        }
    }

    private static boolean check() {
        int a = 0;
        int b = 0;

        for (char c : code) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                a++;
            }else{
                b++;
            }
        }

        if (a >= 1 && b >= 2) {
            return true;
        }
        return false;
    }

}
