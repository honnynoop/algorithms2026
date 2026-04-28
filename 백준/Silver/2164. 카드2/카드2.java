import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
    
    private static int solution(int n) {
        if (n == 1) return 1;
        if ((n & 1) == 0) return 2 * solution(n / 2);
        int half = solution(n / 2);
        if (half == n / 2) return 2;
        else return 2 * (half + 1);
    }
}