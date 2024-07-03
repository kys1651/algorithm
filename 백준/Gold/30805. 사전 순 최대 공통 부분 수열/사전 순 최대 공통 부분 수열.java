import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point> {
        int value;
        int idx;

        public Point(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point o) {
            if (value != o.value) return value - o.value;
            return o.idx - this.idx;
        }
    }

    static int la, ra, lb, rb;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        ra = Integer.parseInt(br.readLine());
        int[] a = new int[ra];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ra; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        rb = Integer.parseInt(br.readLine());
        int[] b = new int[rb];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rb; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }// Input End

        if (ra > rb) {
            int[] tmpArr = a;
            a = b;
            b = tmpArr;
            int tmp = ra;
            ra = rb;
            rb = tmp;
        }

        while(true){
            ArrayList<Point> listA = getList(la, ra, a);
            ArrayList<Point> listB = getList(lb, rb, b);
            if(!getCommon(listA,listB)){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for(int idx : answer){
            sb.append(b[idx]).append(' ');
        }
        System.out.println(sb);
    }

    private static boolean getCommon(ArrayList<Point> a, ArrayList<Point> b) {
        int aIdx = a.size()-1, bIdx =b.size()-1;
        while(aIdx >= 0 && bIdx >= 0){
            Point pA = a.get(aIdx);
            Point pB = b.get(bIdx);
            if(pA.value == pB.value){
                la = pA.idx + 1;
                lb = pB.idx + 1;
                answer.add(b.get(bIdx).idx);
                return true;
            }else if(pA.value > pB.value){
                aIdx--;
            }else{
                bIdx--;
            }
        }

        return false;
    }

    private static ArrayList<Point> getList(int l, int r, int[] arr) {
        ArrayList<Point> list = new ArrayList<>();
        for (int i = l; i < r; i++) {
            list.add(new Point(arr[i], i));
        }
        Collections.sort(list);
        return list;
    }
}