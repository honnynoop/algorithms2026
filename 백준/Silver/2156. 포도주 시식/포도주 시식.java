import java.util.Scanner;

public class Main {

    static int N;
    static int[] wine;  // 각 포도주 잔의 양을 저장하는 배열
    static int[] dp;    // 동적 계획법을 위한 배열
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        wine = new int[N+1];  // 1부터 시작하는 인덱스 사용
        dp = new int[N+1];
        
        // 각 포도주 잔에 들어있는 포도주의 양 입력 받기
        for (int i = 1; i <= N; i++) {
            wine[i] = scanner.nextInt();
        }
        
        // DP 초기화 - 특수 경우 처리
        if (N >= 1) {
            dp[1] = wine[1];
        }
        
        if (N >= 2) {
            dp[2] = wine[1] + wine[2];
        }
        
        // DP 점화식을 통한 계산
        // dp[i]는 i번째 포도주까지 고려했을 때 최대로 마실 수 있는 포도주의 양
        // 세 가지 경우 고려:
        // 1. i번째 포도주를 안 마시는 경우: dp[i-1]
        // 2. i번째 포도주를 마시고 i-1번째는 안 마시는 경우: dp[i-2] + wine[i]
        // 3. i번째와 i-1번째를 모두 마시고 i-2번째는 안 마시는 경우: dp[i-3] + wine[i-1] + wine[i]
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
        }
        
        System.out.println(dp[N]);
        scanner.close();
    }
}