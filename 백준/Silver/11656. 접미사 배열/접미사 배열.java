import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            answer.add(line.substring(i));
        }
        Collections.sort(answer);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
