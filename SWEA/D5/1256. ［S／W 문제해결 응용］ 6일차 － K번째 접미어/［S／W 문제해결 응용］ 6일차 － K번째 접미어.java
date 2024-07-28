import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            char[] input = br.readLine().toCharArray();
            StringBuilder s = new StringBuilder();
            TreeSet<String> set = new TreeSet<>((o1, o2) -> o1.compareTo(o2));
            for (int i = input.length - 1; i >= 0; i--) {
                s.insert(0, input[i]);
                set.add(s.toString());
            }
            int i = 0;
            for (String keyword : set) {
                if(++i == K){
                    sb.append('#').append(tc).append(' ').append(keyword).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    }

}