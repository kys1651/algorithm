import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution {
    static private String NONE = "none";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            TreeSet<String> set = new TreeSet<>(String::compareTo);
            char[] input = br.readLine().toCharArray();
            for (int i = 0; i < input.length; i++) {
                StringBuilder s = new StringBuilder();
                for(int j = i; j < input.length; j++) {
                    s.append(input[j]);
                    set.add(s.toString());
                }
            }
            if (K > set.size()) {
                sb.append('#').append(tc).append(' ').append(NONE).append('\n');
                continue;
            }

            int count = 0;
            for (String word : set) {
                if(++count == K){
                    sb.append('#').append(tc).append(' ').append(word).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    }

}