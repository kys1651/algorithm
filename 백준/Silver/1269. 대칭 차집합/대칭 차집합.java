import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Map<Integer,Integer> mapA = new HashMap<>();
        Map<Integer,Integer> mapB = new HashMap<>();
        int count = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < a; i++){
            mapA.put(Integer.parseInt(st.nextToken()),i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < b; i++){
            int n = Integer.parseInt(st.nextToken());
            if(mapA.containsKey(n))
                mapA.remove(n);
            else{
                count++;
            }
        }

        count += mapA.size();
        System.out.println(count);

    }
}