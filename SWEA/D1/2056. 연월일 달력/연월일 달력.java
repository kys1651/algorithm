import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            bw.write("#" + testCase + " " + checkCal(br.readLine()) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static String checkCal(String tmp) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(tmp.substring(0, 4));
        int month = Integer.parseInt(tmp.substring(4, 6));
        int day = Integer.parseInt(tmp.substring(6));

        if ((month < 1 || month > 12) || (day < 1 || day > days[month - 1])) {
            return "-1";
        }
        String zero = "";
        int yearlen = 4 - String.valueOf(year).length();
        while (yearlen-- > 0) {
            zero += "0";
        }

        return zero + year + (month < 10 ? "/0" : "/") + month + (day < 10 ? "/0" : "/") + day;
    }
}
