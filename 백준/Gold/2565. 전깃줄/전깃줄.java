import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static class L implements Comparable<L>{
		int l;
		int r;
		public L(int l, int r) {
			super();
			this.l = l;
			this.r = r;
		}
		@Override
		public int compareTo(L o) {
			return Integer.compare(l, o.l);
		}	
	} 
	static int N;
	static L[] lines;
	static int [] dp;
	static int cnt;
	public static void main(String[] args) {
		int T=500;
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		lines=new L[N];
		dp=new int[N];
		for (int i = 0; i < N; i++) {
			int l=scann.nextInt();
			int r=scann.nextInt();
			lines[i]=new L(l,r);
		}
		Arrays.sort(lines);
		cnt=0;
		for (int i = 0; i <N; i++) {
			dp[i]=1;
			for (int j = 0; j <i; j++) {
				if(lines[i].r >lines[j].r && (dp[i]<dp[j]+1)){
					dp[i]=dp[j]+1;
				}
			}
			cnt=Math.max(cnt, dp[i]);
		}
		System.out.println(N-cnt);
	}
}
