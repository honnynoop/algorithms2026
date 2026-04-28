import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] stare;
	static int P=1_000_000_000;
	static int[] sum;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		stare=new int[11][N+1];
		sum=new int[N+1];
		//초기화 01111111110
		for (int i = 1; i < 10; i++) {
			stare[i][1]=1;
		}

		// 계산
		for (int j = 2; j < N+1; j++) {
			for (int i = 0; i < 11; i++) {
				if(i==0) {
					stare[i][j]=(stare[i+1][j-1])%P;
				}else if(i==10) {
					stare[i][j]=0;
				}
				else  {
					stare[i][j]=((stare[i-1][j-1])%P+(stare[i+1][j-1])%P)%P;
				}
			}
		}
		for (int j = 1; j < N+1; j++) {
			int tot=0;
			for (int i = 0; i < 11; i++) {
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
