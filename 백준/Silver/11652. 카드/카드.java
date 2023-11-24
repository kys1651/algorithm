import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Long,Integer> map = new HashMap<>();
        int n =Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            long val = Long.parseLong(br.readLine());
            map.put(val,map.getOrDefault(val, 0)+1);
        }
        int max = 0;
        long result = Long.MAX_VALUE;
        for(long key :map.keySet()){
            int count = map.get(key);
            if(max <= count){
                if(max == count){
                    result = Math.min(key,result);
                }else{
                    result = key;
                }
                max = count;
            }
        }
        System.out.println(result);

    }
}