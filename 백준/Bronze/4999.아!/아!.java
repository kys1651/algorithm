import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String check = br.readLine();
        System.out.println(input.contains(check) ? "go" : "no");
    }
}
