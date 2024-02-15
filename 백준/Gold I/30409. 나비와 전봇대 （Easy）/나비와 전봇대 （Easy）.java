import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Top {
        int idx;
        long height;

        public Top(int idx, long height) {
            this.idx = idx;
            this.height = height;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Top[] tops = new Top[N + 1];
        long[] left = new long[N + 1];
        long[] right = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tops[i] = new Top(i, Long.parseLong(st.nextToken()));
        }

        Stack<Top> leftTop = new Stack<>();
        leftTop.push(tops[1]);
        for (int i = 2; i <= N; i++) {
            while (!leftTop.isEmpty() && leftTop.peek().height < tops[i].height) {
                leftTop.pop();
            }
            if (!leftTop.isEmpty()) {
                left[i] = left[leftTop.peek().idx] + getDistance(leftTop.peek(), tops[i]);
            }
            leftTop.add(tops[i]);
//            System.out.println(i + " : " + left[i]);
        }

//        System.out.println("----");
        Stack<Top> rightTop = new Stack<>();
        rightTop.push(tops[N]);
        for (int i = N - 1; i >= 1; i--) {
            while(!rightTop.isEmpty() && rightTop.peek().height < tops[i].height){
                rightTop.pop();
            }
            if(!rightTop.isEmpty()){
                right[i] = right[rightTop.peek().idx] + getDistance(tops[i], rightTop.peek());
            }
            rightTop.push(tops[i]);
        }
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            int p = Integer.parseInt(br.readLine());
            System.out.println(left[p] + right[p]);
        }
    }

    private static long getDistance(Top a, Top b) {
//        System.out.println(a.idx + ", " + a.height + " cal  " + b.idx + " " + b.height);
        long x = a.idx - b.idx;
        long y = a.height - b.height;
//        System.out.println(x * x + y * y);
        return x * x + y * y;
    }
}

