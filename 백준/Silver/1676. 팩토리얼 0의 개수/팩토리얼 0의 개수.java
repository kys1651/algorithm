import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 주어진 값 중 2, 5가 몇번 들어가있는지를 확인해야함
        // 2는 5보다 훨씬 많이 들어가기때문에 0의 개수는 5가 결정한다. -> 즉 5의 개수만 세어주면 됨
        // 5! -> 5가 한번
        // 10! -> 5, 10(5 x 2)
        // 15! -> 5, 10(5 x 2), 15(3 x 5)
        // 20! -> 5, 10(5 x 2), 15(3 x 5), 20(4 x 5)
        // 25! -> 5, 10(5 x 2), 15(3 x 5), 20(4 x 5), 25(5 x 5)
        int answer = 0;
        for(int i = 1; i <= n; i++){
            // 5로 나누어 떨어진다면
            if( i % 5 == 0){
                // num에 i를 저장해줌
                int num = i;
                // 5의 제곱수도 있을 수 있으므로 확인하여 더해준다.
                while(num % 5 == 0){
                    num /= 5;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
