import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static String[] graph;
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++) {
            n = Integer.parseInt(br.readLine());
            graph = new String[n+1];
            for(int i = 1; i <= n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                graph[Integer.parseInt(st.nextToken())] = st.nextToken();
            }

            sb.append("#" + tc + " ");
            // 중위순회
            LVR(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void LVR(int V){
        int left = V * 2;
        if(left <= n){
            LVR(left);
        }
        sb.append(graph[V]);
        if(left + 1 <= n){
            LVR(left+1);
        }
    }
}