import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static double[][] W;
	static int [][] point;
	static double[][] dp;
	static double min;
	static int INF=Integer.MAX_VALUE/100;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		W=new double[N][N];
		point=new int[N][2];
		dp=new double[1<<N][N];
		for (int i = 0; i < (1<<N); i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i <N; i++) {
			point[i][0]=scann.nextInt();
			point[i][1]=scann.nextInt();
		}
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				W[i][j]=distance(i,j);
				W[j][i]=W[i][j];
			}
		}
		min=tsp(1,0);
		System.out.printf("%.6f",min);
	}

	static double tsp(int visited, int city) {
		if(visited==(1<<N)-1) {
			if(W[city][0]==0) return INF;
			return W[city][0];
		}
		if(dp[visited][city]!=-1)  return dp[visited][city];
		dp[visited][city]=INF; // 방문
		for (int i = 0; i < N; i++) {
			// 중복방문x  다음도시i
			if((visited &(1<<i))!=0)continue;
			// 도시가 연결안됨 -> city에서 다음도시i
			if(W[city][i]==0)continue;
			// 방문한 도시 포함, 다음도시i
			double res=tsp(visited |(1<<i),i)+W[city][i];
			dp[visited][city]=Math.min(res, dp[visited][city]);
		}
		
		return dp[visited][city];
	}

	static double distance(int i, int j) {
		double x=(point[i][0]-point[j][0]);
		double y=(point[i][1]-point[j][1]);
		return Math.sqrt(x*x+y*y);
	}
	
}