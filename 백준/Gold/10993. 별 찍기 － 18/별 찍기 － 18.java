import java.util.Arrays;
import java.util.Scanner;

public class Main{

	static int N;
	static int[][] star;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		int M=(int)Math.pow(2, N)-1;
		int K=(int)Math.pow(2, N+1)-3;
		star=new int[M][K];
		star(0,0,N);
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringBuilder sbt=new StringBuilder();
			for (int j = 0; j < K; j++) {
				sbt.append(star[i][j]==1?"*":" ");
			}
			String s=sbt.toString();
			int index=s.lastIndexOf('*');
			sb.append(s.substring(0,index+1));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void star(int r, int c, int n) {
		int m=(int)Math.pow(2, n)-1;
		int k=(int)Math.pow(2, n+1)-3;
		if(n<1) {
			return;
		}else if(n%2==0) {//짝수
			for (int i = 0; i < m; i++) {
				if(i==0) {
					for (int j = 0; j < k; j++) {
						star[r+i][c+j]=1;
					}
				}else if(i==m-1) {
					star[r+i][c+k/2]=1;
				}else {
					star[r+i][c+i]=1;
					star[r+i][c+k-i-1]=1;
				}
			}
			star(r+1, c+k/4+1,n-1);
		}else if(n%2==1) {//홀수
			for (int i = 0; i < m; i++) {
				if(i==m-1) {
					for (int j = 0; j < k; j++) {
						star[r+i][c+j]=1;
					}
				}else if(i==0) {
					star[r+i][c+k/2]=1;
				}else {
					star[r+i][c+m-1-i]=1;
					star[r+i][c+k/2+i]=1;
				}
			}
			star(r+m/2, c+m-m/2,n-1);
		}
	}

}
