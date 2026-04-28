import java.util.Scanner;

public class Main {

	static int N;
	static int[][] magic;
	static int n;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		magic=new int[N][N];
		StringBuilder sb=new StringBuilder();
		
		if(N%2==1) {
			make3(sb);
		}else if(N%4==0) {
			make4(sb);
		}else {
			make6(sb);
		}
		
		System.out.println(sb.toString());
	}
	public static void make6(StringBuilder sb) {
		int m=N/2;
		for (int i = 0; i <m; i++) {
			for (int j = 0; j < m/2; j++) {
				if(i!=m/2){magic[i][j]=3;}
				else magic[i][j+1]=3;
			}
		}
		for (int i = 0; i <m; i++) {
			for (int j = 0; j < m; j++) {
				magic[i][j+m]=1;
			}
		}
		for (int i = 0; i <m; i++) {
			for (int j = 0; j < m-(m/2-1); j++) {
				magic[i][j+m]=2;
			}
		}
		for (int i = 0; i <m; i++) {
			for (int j = 0; j < m; j++) {
				if(magic[i][j]==0) {
					magic[i+m][j]=3;
				}else {
					magic[i+m][j]=0;
				}
				if(magic[i][j+m]==1) {
					magic[i+m][j+m]=2;
				}else {
					magic[i+m][j+m]=1;
				}
			}
		}
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				magic[i][j]*=(m*m);
			}
		}
		int K=N/2;
		int[][] omd=new int[K][K];
		int r=0;
		int c=K/2;
		for (int i = 1; i < K*K+1; i++) {
			omd[r][c]=i;
			int tempR=r;
			int tempC=c;
			if(r-1<0) {
				r=K-1;
			}else {
				r--;
			}
			if(c-1<0) {
				c=K-1;
			}else {
				c--;
			}
			if(omd[r][c]!=0) {
				r=tempR+1;
				c=tempC;
			}
		}
		for (int i = 0; i <m; i++) {
			for (int j = 0; j < m; j++) {
				magic[i][j]+=omd[i][j];
				magic[i][j+m]+=omd[i][j];
				magic[i+m][j]+=omd[i][j];
				magic[i+m][j+m]+=omd[i][j];
			}
		}
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(magic[i][j]+" ");
			}
			sb.append("\n");
		}
		
	}
	public static void make4(StringBuilder sb) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				magic[i][j]=i*N+j+1;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if((i>=0 && i<N/4) || ( i>=N/4*3)) {
					if(j>=N/4 && j<N/4*3) {
						magic[i][j]=N*N-(i*N+j);
					}
				}else {
					if((j>=0 && j<N/4) || ( j>=N/4*3)) {
						magic[i][j]=N*N-(i*N+j);
					}
				}
			}
		}
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(magic[i][j]+" ");
			}
			sb.append("\n");
		}
	}
	
	public static void make3(StringBuilder sb) {
		int r=0;
		int c=N/2;
		for (int i = 1; i < N*N+1; i++) {
			magic[r][c]=i;
			int tempR=r;
			int tempC=c;
			if(r-1<0) {
				r=N-1;
			}else {
				r--;
			}
			if(c-1<0) {
				c=N-1;
			}else {
				c--;
			}
			if(magic[r][c]!=0) {
				r=tempR+1;
				c=tempC;
			}
		}
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(magic[i][j]+" ");
			}
			sb.append("\n");
		}
	}
}