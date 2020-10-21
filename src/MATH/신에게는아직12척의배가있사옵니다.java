package MATH;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신에게는아직12척의배가있사옵니다 {
    static double A,B;
    static boolean[] sosu;
    static double result;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());


        sosu = new boolean[18+1];
        Arrays.fill(sosu, true);
        A = A/100.0;
        B = B/100.0;
        BigDecimal bA = new BigDecimal(A);
        BigDecimal mA = new BigDecimal(1-A);


        BigDecimal bB = new BigDecimal(B);
        BigDecimal mB = new BigDecimal(1-B);
        //result = new BigDecimal(0);

        sosu[0] = false;
        sosu[1] = false;
        for (int i = 3; i <= 18; i++) {
            if(i % 2 == 0)
                sosu[i] = false;

            for (int j = 3; j*2 < i ; j+=2) {
                if(i % j == 0){
                    sosu[i] = false;
                    break;
                }
            }
        }
        int cnt = 0;

        for (int i = 0; i <= 18; i++) {
            for (int j = 0; j <= 18; j++) {
                if(!sosu[i] && !sosu[j]){
                    BigDecimal p;

                    double a = comb(18, i) * Math.pow(A,i) * Math.pow((1.0-A),18 - i) ;
                    double b = comb(18, j) * Math.pow(B,j) * Math.pow((1.0-B),18 - j) ;
                    //double temp = comb(18, i) * bA.pow(i) * (1.0-A).pow(18 - i) *
                    //comb(18, j) * Math.pow(B, j) * Math.pow(1.0 - B, 18 - j);
                    //a = a.setScale(7,RoundingMode.HALF_UP);
                    //b = b.setScale(7,RoundingMode.HALF_UP);
                    result += a*b;
                    //result = result.add((a.multiply(b)));
                    //result = result.setScale(8,RoundingMode.HALF_UP);
                    //System.out.println("("+i+","+j+") " + a + " , " + b + " : " + result);
                    //System.out.println("A : " + A + " 1.0-A : " + (1.0-A) + " : " + Math.pow(0.5, 18));
                    //System.out.println(i + " : Math.pow(A, i) : " + Math.pow(A, i) + " Math.pow(1.0 - A, 18 - i) : " + Math.pow(1.0 - A, 18 - i) + " temp : " + temp + " , "  + result);
                }
            }
        }
        //result = result.setScale(6,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(1-result);
        //System.out.printf("%6f",1.0 - result);

    }

    public static int comb(int n, int r) {
        if (n == r || r == 0)
            return 1;
        else
            return comb(n - 1, r) + comb(n - 1, r - 1);
    }



}