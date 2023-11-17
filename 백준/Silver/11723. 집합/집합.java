import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        while(n --> 0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){
                int tmp = Integer.valueOf(st.nextToken());
                set.add(tmp);
            }else if(command.equals("remove")){
                int tmp = Integer.valueOf(st.nextToken());
                set.remove(tmp);
            }else if(command.equals("check")){
                int tmp = Integer.valueOf(st.nextToken());
                sb.append(set.contains(tmp) ? "1" : "0").append("\n");
            }else if(command.equals("toggle")){
                int tmp = Integer.valueOf(st.nextToken());
                if(set.contains(tmp)){
                    set.remove(tmp);
                }else{
                    set.add(tmp);
                }
            }else if(command.equals("all")){
                for(int i =1 ; i <= 20; i++){
                    set.add(i);
                }
            }else{
                set.clear();
            }
        }
        System.out.println(sb.toString());
    }
}