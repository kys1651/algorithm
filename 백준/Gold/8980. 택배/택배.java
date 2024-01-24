import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 마을의 수
        int n = Integer.parseInt(st.nextToken());
        // 용량의 limit
        int c = Integer.parseInt(st.nextToken());
        int[] addTown = new int[n + 1];
        int[] subTown = new int[n + 1];
        // 박스 정보의 개수
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            addTown[from] += value;
            subTown[to] += value;
        }

        // 싣는 박스의 개수가 상한보다 크다면 어차피 갖지 못함
        for (int i = 1; i <= n; i++) {
            if(addTown[i] >= c){
                addTown[i] = c;
            }
        }

        int result = 0;
        int curBox = 0;
        for (int i = 1; i <= n; i++) {
            // 박스 배달 가능하다면
            if (subTown[i] > 0) {
                // 현재 가진 박스보다 많이 제출 할 수 있다면 전부 반환
                if(subTown[i] > curBox){
                    result += curBox;
                    curBox = 0;
                }
                // 현재 가진 박스보다 많이 가지고 있다면 낼 수 있는건 다 낸다.
                else{
                    result += subTown[i];
                    curBox -= subTown[i];
                }
            }
            // 박스 수령 가능 하고 보내는 택배가 있다면
            if(curBox < c && addTown[i] > 0){
                if(curBox + addTown[i] > c){
                    curBox = c;
                }else{
                    curBox += addTown[i];
                }
            }
        }
        System.out.println(result);
    }
}