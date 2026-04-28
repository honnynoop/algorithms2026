import java.util.Scanner;

public class Main {

	static int [] dr= { 0,1,0,-1};
	static int [] dc= {-1,0,1, 0};
	static int M, K;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		if(N==1) {
			System.out.println('*');
		}else {
			M=4*N-1;
			K=4*N-3;
			int[][] star=new int[M][K];
			int r=0;
			int c=K-1;
			int d=0;
			int cnt=0;
			while(true) {				
				if(cnt==K +1) break;// 끝나는 조건 
				star[r][c]=1;
				int nr=r+dr[d];
				int nc=c+dc[d];
				int nr2=r+2*dr[d];
				int nc2=c+2*dc[d];
				if(check(nr2,nc2) && star[nr2][nc2]==1) {
					d=(d+1)%4;
					cnt++;
				}
				if(!check(nr,nc)) {
					d=(d+1)%4;
					cnt++;
				}
				r=r+dr[d];
				c=c+dc[d];
			}
			StringBuilder sb=new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.setLength(0);
				for (int j = 0; j < K; j++) {
					sb.append(star[i][j]==1 ? '*' :' ');
				}
				//sb.append('\n');
				System.out.println(sb.toString().trim());
			}
			
		}

	}
	private static boolean check(int r, int c) {
		return r>=0 && r<M && c>=0 && c<K;
	}
}
