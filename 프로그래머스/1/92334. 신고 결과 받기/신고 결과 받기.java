import java.util.HashMap;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> idx = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        boolean[][] state = new boolean[id_list.length][id_list.length];
        for(int i = 0; i < id_list.length; i++){
            idx.put(id_list[i], i);
        }
        for(int i = 0; i < report.length; i++){
            String[] users = report[i].split(" ");
            int x = idx.get(users[0]);
            int y = idx.get(users[1]);
            if(!state[x][y]){
                state[x][y] = true;
                count.put(users[1],count.getOrDefault(users[1],0)+1);
            }
        }
        for(int i = 0; i < state.length; i++){
            int tmp =0;
            for(int j = 0; j <state[i].length; j++){
                if(state[i][j] && count.get(id_list[j]) >= k){
                    tmp ++;
                }
            }
            answer[i] = tmp;
        }
        return answer;
    }

}