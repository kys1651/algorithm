import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            String[] curTime = sc.next().split(":");
            String[] promiseTime = sc.next().split(":");
            int curSecond = parseTime(curTime);
            int promiseSecond = parseTime(promiseTime);
            if (curSecond > promiseSecond) {
                promiseSecond += parseTime(new String[] {"24", "00", "00"});
            }
            int resultTime = promiseSecond - curSecond;
            int hour = resultTime / 60 / 60;
            int min = resultTime / 60 % 60;
            int sec = resultTime % 60;
            System.out.println("#" + tc + " " + (hour < 10 ? "0" + hour : hour) + ":"
                    + (min < 10 ? "0" + min : min) + ":" + (sec < 10 ? "0" + sec : sec));
        }
    }

    private static int parseTime(String[] time) {
        int hour = Integer.valueOf(time[0]);
        int min = Integer.valueOf(time[1]);
        int sec = Integer.valueOf(time[2]);
        return (hour * 60 + min) * 60 + sec;
    }
}
