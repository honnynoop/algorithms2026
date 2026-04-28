
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(inputs[j-1]);
            }
        }

        if(map[N][N]==1){
            System.out.println(0);
            return;
        }

        long[][][] dp = new long[N+1][N+1][3];
        dp[1][2][0] = 1; 


        // DP
        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if(map[i][j]==1) continue;// 벽인가?

                // 가로 (0)  -
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                if(i==1) continue; // 맨 윗줄

                // 세로 (1)  |
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if(map[i-1][j]==1 || map[i][j-1]==1) continue;

                // 대각선 (2) \
                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }

        System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
    }
}
