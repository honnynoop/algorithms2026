import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		int M=2*N-1;
		int P=2*N-3;
		int K=2*N+P;
		int[][] star=new int[M][K];
		for (int i = 0; i < M; i++) {
			if(i==0 || i==M-1) {
				for (int j = 0; j < N; j++) {
					star[i][j]=1;
				}
				for (int j = P+N; j < K; j++) {
					star[i][j]=1;
				}
			}else {
				star[i][-Math.abs(i-M/2)+M/2]=1;
				star[i][-Math.abs(i-M/2)+M/2+N-1]=1;
				star[i][P+Math.abs(i-M/2)-M/2+N]=1;
				star[i][P+Math.abs(i-M/2)-M/2+N-1+N]=2;
			}
		}
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.setLength(0);
			for (int j = 0; j < K; j++) {
				if(star[i][j]==1) {
					sb.append('*');
				}else if(star[i][j]==0) {
					sb.append(" ");
				}else if(star[i][j]==2) {
					sb.append('*');
					break;
				}
			}
			System.out.println(sb.toString());
		}
		
	}
}
