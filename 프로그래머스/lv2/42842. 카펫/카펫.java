import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        // brown(10) - 4 -> 6
        // yellow - 2
        // 6 / 2 -> 3의 약수 확인(1,3)
        // 2 - (1,2) -> 합이 3이 됨 그러면 4,3이 됨

        // brown(8) - 4 -> 4
        // yellow - 1
        // 4 / 2 -> 2의 약수 확인(1,2)
        // yellow - 1 -> 2씩 더해줌 (3,3);
        
        // brown(24) - 4 -> 20
        // yellow - 24
        // 20 / 2 -> 10의 약수 확인(1,2,5,10)
        // 24 - (1, 24), (2,12), (3,8), (4,6) v - 2씩 더해줌
        int brownCore = brown - 4;
        brownCore /= 2;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(brownCore); i++){
            if(brownCore % i== 0){
                list.add(i);
                list.add(brownCore/i);
            }
        }

        int x = 0;
        int y = 0;
        for(int i = 1 ; i <= Math.sqrt(yellow); i++){
            if(yellow % i == 0){
                x = i;
                y = yellow / i;
                if(list.contains(x+y)){
                    break;
                }
            }
        }
        x += 2;
        y += 2;
        return new int[]{Math.max(x,y),Math.min(x,y)};
    }
}