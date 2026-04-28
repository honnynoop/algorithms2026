import java.util.Scanner;
public class Main {

	static int N, M;
	static int [] m;
	static int [] c;
	static int [][]dp;
	static int min;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		m=new int[N+1];
		c=new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			m[i]=scann.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			c[i]=scann.nextInt();
		}
		int sumc=0;
		for (int i = 1; i <= N; i++) {
			sumc+=c[i];
		}
		int ans = Integer.MAX_VALUE;
		dp=new int[N+1][sumc+1];
		
	    dp[0][c[0]] = m[0];
	    for(int i = 1; i <= N; i++) {
	        for(int j = 0; j < dp[i].length; j++) {
	                if(j-c[i] >= 0)
	                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-c[i]]+m[i]);

	                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);

	                if(dp[i][j] >= M) {
	                    ans = Math.min(ans, j);
	                }
	        }
	    }
	    //print(dp);
	    System.out.println(ans);
	}
	public static void print(int [][]m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}
}
/*

5 60
30 10 20 35 40
3 0 3 5 4

*/