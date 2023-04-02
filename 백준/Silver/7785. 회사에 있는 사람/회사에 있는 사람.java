import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if(map.containsKey(name)){
                map.remove(name);
            }
            else{
                map.put(name, state);
            }
        }

        ArrayList<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list,Collections.reverseOrder());

        for(int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}