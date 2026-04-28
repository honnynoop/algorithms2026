import java.util.Arrays;
import java.util.Scanner;

public class Main{

	static int N;
	static long[][] stare;
	static long P=Long.MAX_VALUE;
	static long[] sum;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		stare=new long[2][N+1];
		sum=new long[N+1];
		//초기화 1
		stare[1][1]=1L;

		// 계산
		for (int j = 2; j < N+1; j++) {
			stare[0][j]=stare[0][j-1]+stare[1][j-1];
			stare[1][j]=stare[0][j-1];
		}
		for (int j = 1; j < N+1; j++) {
			long tot=0L;
			for (int i = 0; i < 2; i++) {
				tot=(tot+stare[i][j])%P;
			}
			sum[j]=(tot)%P;
		}
		/*
		for (int i = 0; i < 11; i++) {
			System.out.println(Arrays.toString(stare[i]));
		}
		System.out.println();
		
		System.out.println(Arrays.toString(sum));
		*/
		System.out.println(sum[N]);
	}

}
