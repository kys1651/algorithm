import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,Integer> nameMap = new HashMap<>();
        String[] nameArr = new String[N+1];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            String tmp = br.readLine();
            nameMap.put(tmp, i);
            nameArr[i] = tmp;
        }

        while(M --> 0){
            String find = br.readLine();

            if(isStringNumber(find)){
                int index = Integer.parseInt(find);
                sb.append(nameArr[index]);
            }else{
                sb.append(nameMap.get(find));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    public static boolean isStringNumber(String find) {
        try{
            Integer.parseInt(find);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}