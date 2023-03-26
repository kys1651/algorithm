import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String str = br.readLine();

        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i <= str.length(); i++) {
            for(int j = 0 ; j+i < str.length(); j++){
                map.put(str.substring(j, j + i + 1), true);
            }
        }
        
        System.out.println(map.size());
    }
}