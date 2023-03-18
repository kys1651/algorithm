import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double sum = 0;
        double result = 0;

        for(int i = 0 ; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double a = Double.parseDouble(st.nextToken());
            String s = st.nextToken();

            if(s.equals("P")) continue;
            sum += a;

            switch (s){
                case "A+":
                    result += 4.5 * a;
                    break;
                case "A0":
                    result += 4.0 * a;
                    break;
                case "B+":
                    result += 3.5 * a;
                    break;
                case "B0":
                    result += 3.0 * a;
                    break;
                case "C+":
                    result += 2.5 * a;
                    break;
                case "C0":
                    result += 2.0 * a;
                    break;
                case "D+":
                    result += 1.5 * a;
                    break;
                case "D0":
                    result += 1.0 * a;
                    break;
                case "F":
                    result += 0 * a;
                    break;
                case "P":
                    break;
            }
        }

        System.out.printf("%.6f",result/sum);

    }
}