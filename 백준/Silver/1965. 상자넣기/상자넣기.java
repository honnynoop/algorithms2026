import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int N=0;
		int[] su=null;
		int[] dp=null;
		int size=0;
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		su=new int[N];
		dp=new int[N];

		for (int i = 0; i < N; i++) {
			su[i]=scann.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			dp[i]=1;
			for (int j = 0; j < i; j++) {
				if(su[j]<su[i] && (dp[i]<dp[j]+1)){
					dp[i]=dp[j]+1;
				}
			}
			size=Math.max(size, dp[i]);
		}
		
		System.out.println(size);
	}
}
