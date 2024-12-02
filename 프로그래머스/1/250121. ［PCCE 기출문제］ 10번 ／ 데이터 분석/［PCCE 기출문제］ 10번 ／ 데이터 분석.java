import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // data: 코드 번호([0]), 제조일([1]), 최대 수량([2]), 현재 수량([3])
        int extIdx = getIdx(ext);
        int sortIdx = getIdx(sort_by);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[sortIdx] - o2[sortIdx]);
        for(int i = 0; i < data.length; i++){
            if(data[i][extIdx] < val_ext){
                pq.add(data[i]);
            }
        }
        int[][] answer = new int[pq.size()][4];
        int i = 0;
        while(!pq.isEmpty()){
            answer[i++] = pq.poll();
        }
        return answer;
    }
    private static int getIdx(String word){
        String[] idx2String = {"code", "date", "maximum", "remain"};
        for(int i = 0; i < idx2String.length; i++){
            if(word.equals(idx2String[i])){
                return i;
            }
        }
        return -1;
    }
}