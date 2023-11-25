import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i])) {
                int tmp = arr[i] - 'A';
                tmp += 13;
                tmp %= 26;
                arr[i] = (char) ('A' + tmp);
            } else if (Character.isLowerCase(arr[i])) {
                int tmp = arr[i] - 'a';
                tmp += 13;
                tmp %= 26;
                arr[i] = (char) ('a' + tmp);
            }
        }
        System.out.println(arr);
    }
}
