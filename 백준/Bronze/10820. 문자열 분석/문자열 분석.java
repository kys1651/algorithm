import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            int lower = 0;
            int upper = 0;
            int num = 0;
            int space = 0;
            for (char ch : line.toCharArray()) {
                if (Character.isLowerCase(ch)) {
                    lower++;
                } else if (Character.isUpperCase(ch)) {
                    upper++;
                } else if (Character.isDigit(ch)) {
                    num++;
                } else {
                    space++;
                }
            }
            sb.append(lower + " " + upper + " " + num + " " + space + "\n");
        }
        System.out.println(sb.toString());
    }
}
