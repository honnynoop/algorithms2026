import java.util.Scanner;

public class Main {

	static int T,K,N;
	static int[][] dp;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 0; t < T; t++) {
			K=scann.nextInt();
			N=scann.nextInt();
			dp=new int[15][15];
			//BC
			for (int i = 0; i < N+1; i++) {
				dp[0][i]=i;
			}
			for (int k = 1; k < K+1; k++) {
				dp[k][1]=1;
				for (int n = 2; n < N+1; n++) {
					dp[k][n]=dp[k][n-1]+dp[k-1][n];
				}
			}
			System.out.println(dp[K][N]);
		}
	
		
	}

}