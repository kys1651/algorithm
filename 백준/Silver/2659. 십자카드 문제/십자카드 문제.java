import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int min = getMin(nums[0], nums[1], nums[2], nums[3]);
        boolean[] visit = getClockNum();

        int count = 0;
        for(int i = 1111; i <= min; i++){
            if(visit[i]){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean[] getClockNum() {
        boolean[] visit = new boolean[10000];
        for(int a = 1; a <= 9; a++){
            for(int b = 1; b <= 9 ; b++){
                for(int c= 1; c <= 9; c++){
                    for (int d = 1; d <= 9; d++) {
                        int n = getMin(a, b, c, d);

                        if(!visit[n]){
                            visit[n] = true;
                        }
                    }
                }
            }
        }


        return visit;
    }

    private static int getMin(int a, int b, int c, int d){
        int answer = Integer.MAX_VALUE;
        answer = Math.min(answer, a * 1000 + b * 100 + c * 10 + d);
        answer = Math.min(answer, b * 1000 + c * 100 + d * 10 + a);
        answer = Math.min(answer, c * 1000 + d * 100 + a * 10 + b);
        answer = Math.min(answer, d * 1000 + a * 100 + b * 10 + c);

        return answer;
    }
}
