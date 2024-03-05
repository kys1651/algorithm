import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        char[] T = br.readLine().toCharArray();

        int SLen = S.length;
        int TLen = T.length;
        while (SLen != TLen) {
            if (T[TLen - 1] == 'A') {
                TLen--;
            } else {
                TLen--;
                swap(T, TLen - 1);
            }
        }
        if (check(S, T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void print(char[] arr, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    private static boolean check(char[] s, char[] t) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != t[i]) {
                return false;
            }
        }
        return true;
    }


    private static void swap(char[] str, int len) {
        for (int i = 0; i <= len / 2; i++) {
            char tmp = str[i];
            str[i] = str[len - i];
            str[len - i] = tmp;
        }
    }
}
