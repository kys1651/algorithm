import java.util.*;

class Solution {
    static class Point{
        int code;
        int date;
        int maximum;
        int remain;
        
        public Point(int code, int date, int maximum, int remain){
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
        
        public int getValue(String ext){
            if(ext.equals("code")){
                return code;
            }else if(ext.equals("date")){
                return date;
            }else if(ext.equals("maximum")){
                return maximum;
            }
            return remain;
        }
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // data: 코드 번호([0]), 제조일([1]), 최대 수량([2]), 현재 수량([3])
        ArrayList<Point> dataList = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            Point tmpPoint = new Point(data[i][0], data[i][1], data[i][2], data[i][3]);
            if(isValid(tmpPoint, ext, val_ext)){
                dataList.add(tmpPoint);
            }
        }
        dataSortBy(dataList, sort_by);
        
        int[][] answer = new int[dataList.size()][4];
        for(int i = 0; i < dataList.size(); i++){
            Point p = dataList.get(i);
            answer[i][0] = p.code;
            answer[i][1] = p.date;
            answer[i][2] = p.maximum;
            answer[i][3] = p.remain;
        }
        return answer;
    }
    
    private static void dataSortBy(ArrayList<Point> dataList, String sortBy){
        if(sortBy.equals("code")){
            Collections.sort(dataList, (o1,o2) -> o1.code - o2.code);
        }else if(sortBy.equals("date")){
            Collections.sort(dataList, (o1,o2) -> o1.date - o2.date);
        }else if(sortBy.equals("maximum")){
            Collections.sort(dataList, (o1,o2) -> o1.maximum - o2.maximum);
        }else{
            Collections.sort(dataList, (o1,o2) -> o1.remain - o2.remain);
        }
    }
    
    private static boolean isValid(Point p, String ext, int val_ext){
        return val_ext > p.getValue(ext);
    }
}