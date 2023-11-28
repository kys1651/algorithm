import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int result;
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 에라토스테네스의 체 알고리즘으로 소수 미리 구하기
        getPrime();
        StringTokenizer st;
        for(int i = 1; i <= t;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            result = -1;
            solution(start,end);
            sb.append(result == -1?"Impossible":result).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void solution(int start, int end) {
        // 값을 확인하기 위해서 큐를 생성
        Queue<Integer> q = new LinkedList<>();
        // 카운트 값을 저장하기 위한 map
        Map<Integer, Integer> map = new HashMap<>();

        map.put(start, 0);
        q.add(start);
        while(!q.isEmpty()){
            int pos = q.poll();
            int count = map.get(pos);

            if(pos == end){
                result = count;
                return;
            }

            // 첫번째 자리 수, 두번째 자리 수, 세번째 자리 수, 네번째 자리 수를 구해놓음
            int[] pNum = {pos / 1000, (pos / 100) % 10, (pos / 10) % 10, pos % 10};
            for(int i = 0; i < 4; i++){
                for(int j = 0 ; j < 10; j++){
                    // 1000미만은 처리 x
                    if(i == 0 && j == 0) continue;

                    // 해당 자릿값 임시 저장
                    int tmp = pNum[i];
                    pNum[i] = j;
                    // 값 삽입 후 정수로 변환
                    int next = 0;
                    for(int k = 0; k <4; k++){
                        next += (int) (pNum[k] * (Math.pow(10, 3 - k)));
                    }
                    // 다시 원래 숫자로 복구
                    pNum[i] = tmp;

                    // 이미 방문했거나 소수가 아니라면 continue;
                    if(prime[next] || map.containsKey(next)) continue;

                    q.add(next);
                    map.put(next,count+1);
                }
            }
        }
    }

    private static void getPrime(){
        prime = new boolean[10000];
        prime[1] = true;
        for(int i = 2; i <= (int)Math.sqrt(prime.length); i++){
            if(prime[i]) continue;

            for(int j =  i + i; j < prime.length; j+= i){
                prime[j] = true;
            }
        }
    }
}