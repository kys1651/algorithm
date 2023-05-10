import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        while (N-- > 0) {
            String tmp = br.readLine();
            if(tmp.length() < M)
                continue;

            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        //Map을 List로 변환
        List<String> word = map.keySet().stream().collect(Collectors.toList());

        word.sort((o1,o2)->{
            int c1 = map.get(o1);
            int c2 = map.get(o2);

            if(c1==c2){
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);

                return o2.length() - o1.length();
            }
            return c2-c1;
        });

        StringBuilder sb = new StringBuilder();
        for (String s : word) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }


}
