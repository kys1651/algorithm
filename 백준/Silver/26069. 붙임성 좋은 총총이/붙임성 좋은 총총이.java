import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if((a.equals("ChongChong")||b.equals("ChongChong"))
                    ||(set.contains(a)|| set.contains(b))){
                set.add(a);
                set.add(b);
            }
        }

        System.out.println(set.size());

    }


}
