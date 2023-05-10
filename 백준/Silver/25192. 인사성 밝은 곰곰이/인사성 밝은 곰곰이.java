import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0 ;
        int N = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < N; i++){
            String tmp = br.readLine();
            if(tmp.equals("ENTER")){
                set.clear();
                continue;
            }

            if(!set.contains(tmp)){
                set.add(tmp);
                count++;
            }
        }
        System.out.println(count);

    }


}
