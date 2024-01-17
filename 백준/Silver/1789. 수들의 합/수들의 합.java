import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long count = 0;
        while (count * (count + 1) / 2 <= s) {
            count++;
        }
        System.out.println(count - 1);
    }
}
