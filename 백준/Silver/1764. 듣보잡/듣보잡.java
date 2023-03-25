import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            String tmp = br.readLine();
            map.put(tmp, 1);
        }

        while(M --> 0){
            String check = br.readLine();
            map.put(check, map.getOrDefault(check, 0) + 1);
            if(map.get(check)==2) list.add(check);
        }
        Collections.sort(list);
        sb.append(list.size() + "\n");
        for(String s:list){
            sb.append(s +"\n");
        }
        System.out.println(sb);
    }
}