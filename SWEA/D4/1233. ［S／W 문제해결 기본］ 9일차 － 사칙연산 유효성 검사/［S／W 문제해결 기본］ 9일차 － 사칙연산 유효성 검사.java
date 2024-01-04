import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 1;
            // 값을 입력 받을 때는 접근을 인덱스로 하기 위해서 배열로 한다.
            // 연산자면 false, 피연산자라면 true
            for(int i = 1; i <= n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();

                char value = st.nextToken().charAt(0);
                boolean digit = Character.isDigit(value);
                if (st.hasMoreTokens()){
                    // 리프 노드가 아니라면 연산자여야한다.
                    if(digit){
                        answer = 0;
                    }
                }else{
                    // 리프 노드라면 숫자여야한다.
                    if(!digit){
                        answer = 0;
                    }
                }
            }
            sb.append("#" + tc + " " + answer).append("\n");
        }
        System.out.println(sb);
    }
}