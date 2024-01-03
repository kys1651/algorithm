import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            int command =  Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < command; i++){
                st.nextToken();
                int pos = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                for(int j =0; j < count; j++){
                    list.add(pos+j,Integer.parseInt(st.nextToken()));
                }
            }

            sb.append("#" + tc+ " ");
            for(int i = 0; i < 10; i++){
                sb.append(list.get(i)+ " " );
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}