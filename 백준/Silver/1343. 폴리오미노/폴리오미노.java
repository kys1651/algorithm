import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        input = input.replaceAll("XXXX", "AAAA");
        input = input.replaceAll("XX", "BB");

        if(input.contains("X")){
            System.out.println(-1);
        }else{
            System.out.println(input);
        }
    }
}
