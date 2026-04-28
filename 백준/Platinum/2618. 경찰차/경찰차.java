import java.util.Arrays;
import java.util.Scanner;
public class Main{
	static int N, W;
	static int ans;
	static int[][] dp;
	static int[][] P;
	static int[][] who;
	static int K=1023;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		W=scann.nextInt();
		dp=new int[1023][1023];
		P=new int[1023][2];
		who=new int[1023][1023];// 0->1 경찰차 1--> 2
		P[0][0]=P[0][1]=1;
		P[1][0]=P[1][1]=N;
		for (int i = 2; i < W+2; i++) {
			int x=scann.nextInt();
			int y=scann.nextInt();
			P[i][0]=x;
			P[i][1]=y;
		}
		
		for (int i = 0; i <W+2; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		ans=Integer.MAX_VALUE;
		int r=solve(0,1);  // A:P[0] B:P[1], d=0
		System.out.println(r);
		
		for (int x = 0,y=1; Math.max(x, y)+1 < W+2; ) {
			System.out.println(who[x][y]+1);
			if(who[x][y]==1){
				y=Math.max(x, y)+1;
			}else x=Math.max(x, y)+1;
		}
	}
	private static  int  solve(int x, int y) {
		//x->next이동 y->next로 이동
		int next=Math.max(x, y)+1;
		if(next==W+2){
			return 0;
		}
		if(dp[x][y]!=-1){
			return dp[x][y];
		}
		//System.out.println(x+" "+y);
		int A=solve(next,y)+distance(x, next);
		int B=solve(x,next)+distance(next,y );
		if(B<A){
			dp[x][y]=B;
			who[x][y]=1;
		}else{
			dp[x][y]=A;
			who[x][y]=0;
		}
		return dp[x][y];
	}

	public static int distance(int x, int y){
		return Math.abs(P[x][0]-P[y][0])+Math.abs(P[x][1]-P[y][1]);
	}
}
/*
6
3
3 5
5 5
2 3

*/