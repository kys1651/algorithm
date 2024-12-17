import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        // n: 진법
        // t: 미리 구할 숫자의 개수
        // m: 게임에 참가하는 인원
        // p: 튜브의 순서
        // 2, 4, 2, 1이면
        /*
        1. 각 수를 N진수 만들기
        2. N 진수를 전부 연결하기 (길이가 m * t 이상이 될 때 까지)
        3. 튜브의 순서를 기준으로 m만큼 더해주면서 t개 구하기
        출력하면서 그냥 숫자로 만들자.
        */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = 1; list.size() < t * m; i++){
            getNValue(list, n, i);
        }
        StringBuilder answer = new StringBuilder();
        for(int idx = p - 1, size = 0; size < t; size++, idx += m){
            int val = list.get(idx);
            if(val >= 10){
                val = 'A' + val - 10;
            }else{
                val += '0';
            }
            
            answer.append((char)(val));
        }
        return answer.toString();
    }
    
    private static void getNValue(ArrayList<Integer> list, int n, int value){
        Stack<Integer> tmp = new Stack<>();
        while(value != 0){
            tmp.push(value % n);
            value /= n;
        }
        while(!tmp.isEmpty()){
            list.add(tmp.pop());    
        }
    }
}