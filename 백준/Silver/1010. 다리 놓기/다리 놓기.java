import java.util.Scanner;

public class Main {

	static int T, N, M,K=30;
	static long[][] pascal;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner( System.in);
		T=scann.nextInt();
		pascal=new long[K][K];
		pascal[0][0]=1;
		pascal[1][0]=1;
		pascal[1][1]=1;
		//tabluation
		for (int i = 2; i < K; i++) {
			pascal[i][0]=1;
			pascal[i][i]=1;
			for (int j = 1; j < i; j++) {
				pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
			}
		}
		
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			M=scann.nextInt();
			System.out.println(pascal[M][N]);
		}
	}
}