

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    static int M=3;
    static int N;
    static int[][] map;
    static int[][] dp;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new int[N+1][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			dp[i][0]=Integer.parseInt(st.nextToken());
			dp[i][1]=Integer.parseInt(st.nextToken());
			dp[i][2]=Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N+1; i++) {
			dp[i][0]+=Math.min(dp[i-1][1],dp[i-1][2]);
			dp[i][1]+=Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2]+=Math.min(dp[i-1][0],dp[i-1][1]);
		}
		Arrays.sort(dp[N]);
		System.out.println(dp[N][0]);
	}
	
}