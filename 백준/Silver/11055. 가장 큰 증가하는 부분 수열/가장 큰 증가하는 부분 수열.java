import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		int N=0;
		int[] su=null;
		int[] dp=null;
		int tot=0;
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		su=new int[N];
		dp=new int[N];

		for (int i = 0; i < N; i++) {
			su[i]=scann.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			dp[i]=su[i];
			for (int j = 0; j < i; j++) {
				if(su[j]<su[i] && (dp[i]<dp[j]+su[i])){
					dp[i]=dp[j]+su[i];
				}
			}
			tot=Math.max(tot, dp[i]);
		}
		
		System.out.println(tot);
	}
}
