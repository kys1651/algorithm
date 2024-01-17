import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        char[] charArr = new char[N*2];

        for (int i = 0; i < N - 1; i++) {
            charArr[i] = ' ';
        }
        int middle = N-1;

        for (int i = 0; i < N ; i++) {
            charArr[middle+i] = '*';
            charArr[middle-i] = '*';

            for(int j = 0; j <= middle + i; j++){
                System.out.print(charArr[j]);
            }
            System.out.println();
//            System.out.println(String.valueOf(charArr));
        }

        for (int i = N-1; 0 < i; i--) {
            charArr[middle+i] = ' ';
            charArr[middle-i] = ' ';

            for (int j = 0; j < middle + i; j++) {
                System.out.print(charArr[j]);
            }
            System.out.println();
//            System.out.println(String.valueOf(charArr));
        }
        sc.close();
    }
}
