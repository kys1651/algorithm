import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 배열의 첫번째 값
        int a = sc.nextInt();
        // 곱할 수
        int b = sc.nextInt();
        int n = solution(a, b);
        System.out.println(n);
    }

    private static int solution(int num, int expo) {
        ArrayList<Integer> list = new ArrayList<>();
        // list에 num을 추가
        list.add(num);
        while (true) {
            // 가장 최근에 넣은 값을 빼옴
            int n = list.get(list.size() - 1);

            // 각 자리 별로 곱한 수를 계산 할 tmp
            int tmp = 0;
            while (n != 0) {
                // 각 자리수를 expo만큼 제곱 후 tmp에 더해줌
                tmp += (int) Math.pow(n % 10, expo);
                n /= 10;
            }
            // 만약 이미 나온 수라면? 반복수열임으로 인덱스를 찾아서 반환
            if (list.contains(tmp)) {
                return list.indexOf(tmp);
            }
            // 나오지 않은 수라면 리스트에 추가 해줌
            else {
                list.add(tmp);
            }
        }
    }
}
